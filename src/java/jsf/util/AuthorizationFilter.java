package jsf.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        try {
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);

            String reqURI = reqt.getRequestURI();
            
            // 1. ALWAYS ALLOW: Login, Signup, and Resource files (CSS/JS)
            if (reqURI.indexOf("/login.xhtml") >= 0
                    || reqURI.indexOf("/signup.xhtml") >= 0
                    || reqURI.contains("javax.faces.resource")) {
                chain.doFilter(request, response);
                return;
            }

            // 2. CHECK LOGIN STATUS
            if (ses != null && ses.getAttribute("user") != null) {
                // User is logged in. Now check specific permissions.
                String role = (String) ses.getAttribute("userRole");

                // Define folders that ONLY Recruiters can see
                boolean isRecruiterOnlyPage = reqURI.contains("/recruiter/") 
                                           || reqURI.contains("/client/") 
                                           || reqURI.contains("/project/")
                                           || reqURI.contains("/consultant/") // Recruiter manages consultants
                                           || reqURI.contains("/consultantStatus/")
                                           || reqURI.contains("/address/");

                if (isRecruiterOnlyPage) {
                    if ("recruiter".equals(role)) {
                        // Authorized
                        chain.doFilter(request, response);
                    } else {
                        // Unauthorized (e.g., Consultant trying to access Client list)
                        // Redirect to dashboard
                        resp.sendRedirect(reqt.getContextPath() + "/faces/index.xhtml");
                    }
                } else {
                    // Safe pages (Index, Billables, etc.) -> Allow everyone
                    chain.doFilter(request, response);
                }
            } else {
                // Not logged in -> Redirect to Login
                resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {
    }
}