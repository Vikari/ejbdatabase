/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jukka
 */
@Stateless
public class TestiFacade extends AbstractFacade<Testi> implements TestiFacadeLocal {

    @PersistenceContext(unitName = "DataB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestiFacade() {
        super(Testi.class);
    }
    
}
