/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.entities.Ejemplar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inf-cduarte
 */
@Stateless
public class EjemplarFacade extends AbstractFacade<Ejemplar> {

    @PersistenceContext(unitName = "blbiotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EjemplarFacade() {
        super(Ejemplar.class);
    }
    
}
