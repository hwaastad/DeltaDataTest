/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltadatatest.schedule;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import org.apache.openejb.junit.jee.EJBContainerRule;
import org.apache.openejb.junit.jee.InjectRule;
import org.apache.openejb.junit.jee.config.PropertyFile;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.waastad.deltadatatest.repository.PersonRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@PropertyFile("test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JmsTest {

    @ClassRule
    public static final EJBContainerRule CONTAINER_RULE = new EJBContainerRule();
    @Rule
    public final InjectRule injectRule = new InjectRule(this, CONTAINER_RULE);

    public JmsTest() {
    }

    @Resource(name = "DemoConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name = "DemoCacheQueue")
    private Queue questionQueue;

    @Inject
    private PersonRepository personRepository;

    @Test
    public void test10() throws Exception {
        final Connection connection = connectionFactory.createConnection();
        connection.start();
        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        final MessageProducer questions = session.createProducer(questionQueue);
        sendText("textmsg", questions, session);
        session.close();
        connection.close();
        Thread.sleep(5000);
        Assert.assertTrue(personRepository.findAll().size() == 1);
    }

    private void sendText(String text, MessageProducer questions, Session session) throws JMSException {
        questions.send(session.createTextMessage(text));
    }
}
