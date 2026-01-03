/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Recruiter;

/**
 *
 * @author mohd5
 */
@Stateless
public class RecruiterFacade extends AbstractFacade<Recruiter> {

    @PersistenceContext(unitName = "ConsultingAgencyB04PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecruiterFacade() {
        super(Recruiter.class);
    }
    
    public Recruiter findByEmail(String email) {
        try {
            return (Recruiter) em.createNamedQuery("Recruiter.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            // ADD THIS LINE TO SEE THE REAL ERROR IN THE OUTPUT WINDOW
            e.printStackTrace(); 
            return null;
        }
    }
    
}