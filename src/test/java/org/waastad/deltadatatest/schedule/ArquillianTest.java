/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltadatatest.schedule;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@RunWith(Arquillian.class)
public class ArquillianTest {
    
    public ArquillianTest() {
    }
    
    @Deployment
    public static WebArchive war1(){
        return ShrinkWrap.create(WebArchive.class).addClass(MyTimerService.class);
    }

    @Test
    public void testSomeMethod() {
        System.out.println("Test...");
    }
    
}
