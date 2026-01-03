package jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import jpa.entities.Recruiter;
import jpa.entities.Consultant;
import jpa.sessions.RecruiterFacade;
import jpa.sessions.ConsultantFacade;
import jsf.util.JsfUtil;

@Named("loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String email;
    private String password;
    private Recruiter currentRecruiter;
    private Consultant currentConsultant;

    @EJB
    private RecruiterFacade recruiterFacade;
    @EJB
    private ConsultantFacade consultantFacade;

    public String login() {
        // 1. Try to login as Recruiter
        Recruiter recruiter = recruiterFacade.findByEmail(email);
        if (recruiter != null && recruiter.getPassword().equals(password)) {
            currentRecruiter = recruiter;
            currentConsultant = null;
            // Store specific role string for the Filter to check
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userRole", "recruiter");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", recruiter);
            return "/index?faces-redirect=true";
        }

        // 2. Try to login as Consultant
        Consultant consultant = consultantFacade.findByEmail(email);
        if (consultant != null && consultant.getPassword().equals(password)) {
            currentConsultant = consultant;
            currentRecruiter = null;
            // Store specific role string for the Filter to check
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userRole", "consultant");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", consultant);
            return "/index?faces-redirect=true";
        }

        // 3. Login Failed
        JsfUtil.addErrorMessage("Invalid Email or Password");
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }

    // Helper to display a friendly message on the dashboard
    public String getWelcomeMessage() {
        if (currentRecruiter != null) {
            return "Welcome, Recruiter " + currentRecruiter.getEmail();
        } else if (currentConsultant != null) {
            return "Welcome, Consultant " + currentConsultant.getEmail();
        }
        return "";
    }
    
    // Used to render the logout button
    public boolean isLoggedIn() {
        return currentRecruiter != null || currentConsultant != null;
    }

    // --- Role Checkers for UI (used in index.xhtml) ---
    public boolean isRecruiter() {
        return currentRecruiter != null;
    }

    public boolean isConsultant() {
        return currentConsultant != null;
    }

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}