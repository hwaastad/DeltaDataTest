/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltadatatest.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@ApplicationScoped
public class EntityManagerProducer {

//    @PersistenceContext(unitName = "DemoPU")
//    private EntityManager em;
//
//    @Produces
//    @Default
//    public EntityManager create() {
//        System.out.println("Producing entitymanager.....");
//        return em;
//    }

}
