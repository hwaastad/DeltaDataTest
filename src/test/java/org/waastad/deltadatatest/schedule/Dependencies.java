/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltadatatest.schedule;

import java.io.File;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
public class Dependencies {

    private static final Future<File[]> DEPENDENCIES;

    static {
        System.out.println("GO");
        final ExecutorService es = Executors.newSingleThreadExecutor();
        DEPENDENCIES = es.submit(new Callable<File[]>() {
            @Override
            public File[] call() throws Exception {
                return Maven.resolver()
                        .offline()
                        .loadPomFromFile("pom.xml")
                        .importCompileAndRuntimeDependencies()
                        .resolve().withTransitivity()
                        .asFile();
            }
        });
        es.shutdown();
    }

    public static File[] get() {
        System.out.println(new Date());
        try {
            return DEPENDENCIES.get(); // block if not done or return immediately
        } catch (final InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(new Date());
        }
    }
}
