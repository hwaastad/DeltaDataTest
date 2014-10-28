/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltadatatest.jms;

import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.waastad.deltadatatest.entity.Person;
import org.waastad.deltadatatest.repository.PersonRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@MessageDriven(mappedName = "DemoCacheQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class JmsListener implements MessageListener {

    @Inject
    private PersonRepository personRepository;

    @Override
    public void onMessage(Message msg) {
        System.out.println("We got a message.....");
        Person p = new Person("person: " + new Date().toString());
        personRepository.findAll();
        personRepository.save(p);
    }

}
