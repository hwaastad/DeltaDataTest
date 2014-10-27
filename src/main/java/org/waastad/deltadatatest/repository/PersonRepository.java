/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltadatatest.repository;

import javax.persistence.FlushModeType;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Repository;
import org.waastad.deltadatatest.entity.Person;
import org.waastad.deltadatatest.producer.CrmEntityManagerResolver;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Repository
//@EntityManagerConfig(entityManagerResolver = CrmEntityManagerResolver.class, flushMode = FlushModeType.COMMIT)
public abstract class PersonRepository extends AbstractEntityRepository<Person, Long> {

}
