/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Billable;

/**
 *
 * @author mohd5
 */
@Stateless
public class BillableFacade extends AbstractFacade<Billable> {

    @PersistenceContext(unitName = "ConsultingAgencyB04PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillableFacade() {
        super(Billable.class);
    }
    
}
