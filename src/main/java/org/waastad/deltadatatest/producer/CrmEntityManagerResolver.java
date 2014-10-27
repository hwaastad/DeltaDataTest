/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltadatatest.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.deltaspike.data.api.EntityManagerResolver;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@ApplicationScoped
public class CrmEntityManagerResolver implements EntityManagerResolver {

    @PersistenceContext(unitName = "DemoPU")
    private EntityManager em;

    @Override
    public EntityManager resolveEntityManager() {
        return em;
    }

}
