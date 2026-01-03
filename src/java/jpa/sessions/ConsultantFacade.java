/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Consultant;

/**
 *
 * @author mohd5
 */
@Stateless
public class ConsultantFacade extends AbstractFacade<Consultant> {

    @PersistenceContext(unitName = "ConsultingAgencyB04PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultantFacade() {
        super(Consultant.class);
    }
    
    public Consultant findByEmail(String email) {
        try {
            return (Consultant) em.createNamedQuery("Consultant.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}
