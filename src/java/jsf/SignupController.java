package jsf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped; // Using RequestScoped for form submission
import javax.inject.Named;
import jpa.entities.Consultant;
import jpa.entities.ConsultantStatus;
import jpa.entities.Recruiter;
import jpa.sessions.ConsultantFacade;
import jpa.sessions.ConsultantStatusFacade;
import jpa.sessions.RecruiterFacade;
import jsf.util.JsfUtil;

@Named("signupController")
@RequestScoped
public class SignupController implements Serializable {

    private String email;
    private String password;
    private String role = "Recruiter"; // Default role

    @EJB
    private RecruiterFacade recruiterFacade;
    @EJB
    private ConsultantFacade consultantFacade;
    @EJB
    private ConsultantStatusFacade consultantStatusFacade;

    public String register() {
        try {
            if ("Recruiter".equals(role)) {
                return registerRecruiter();
            } else if ("Consultant".equals(role)) {
                return registerConsultant();
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Registration failed: " + e.getMessage());
        }
        return null;
    }

    private String registerRecruiter() {
        // Check if email already exists
        if (recruiterFacade.findByEmail(email) != null) {
            JsfUtil.addErrorMessage("A Recruiter with this email already exists.");
            return null;
        }

        Recruiter newRecruiter = new Recruiter();
        newRecruiter.setEmail(email);
        newRecruiter.setPassword(password);
        
        recruiterFacade.create(newRecruiter);
        JsfUtil.addSuccessMessage("Recruiter Registered Successfully! Please Login.");
        return "/login?faces-redirect=true";
    }

    private String registerConsultant() {
        // Check if email already exists
        if (consultantFacade.findByEmail(email) != null) {
            JsfUtil.addErrorMessage("A Consultant with this email already exists.");
            return null;
        }

        Consultant newConsultant = new Consultant();
        newConsultant.setEmail(email);
        newConsultant.setPassword(password);
        
        // SET DEFAULT VALUES for required fields
        newConsultant.setHourlyRate(BigDecimal.ZERO); // Default rate
        newConsultant.setBillableHourlyRate(BigDecimal.ZERO); // Default rate
        newConsultant.setHireDate(new Date());

        // ASSIGN A DEFAULT STATUS (Required by database)
        // We attempt to find a status "A" (Active) or just pick the first one found.
        List<ConsultantStatus> statuses = consultantStatusFacade.findAll();
        if (statuses.isEmpty()) {
             JsfUtil.addErrorMessage("System Error: No Consultant Statuses defined in database. Cannot register.");
             return null;
        }
        newConsultant.setStatusId(statuses.get(0)); // Assign the first available status

        consultantFacade.create(newConsultant);
        JsfUtil.addSuccessMessage("Consultant Registered Successfully! Please Login.");
        return "/login?faces-redirect=true";
    }

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}