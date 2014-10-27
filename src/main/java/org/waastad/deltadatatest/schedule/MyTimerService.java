/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.deltadatatest.schedule;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Singleton
@Startup
public class MyTimerService {

    private static final String WEB_CACHE_TIMER = "CacheTimer";
    private static final String WEB_CACHE_CHECK_TIMER = "CacheCheckTimer";
    private static final Long CHECK_INTERVAL = 3600000L;
    private static final Long INITIAL_TIMEOUT = 30000L;
    private Long interval = new Long("0");

    @Resource
    private TimerService timerService;

    @PostConstruct
    public void init() {
        System.out.println("Initializing Timer Service.......");
        try {
            String newInterval = "3600";
            long timeUnits = 1000 * Long.parseLong(newInterval);
            TimerConfig config = new TimerConfig(WEB_CACHE_TIMER, false);
            timerService.createIntervalTimer(INITIAL_TIMEOUT, timeUnits, config);
            interval = timeUnits;
        } catch (IllegalArgumentException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        try {
            TimerConfig config2 = new TimerConfig(WEB_CACHE_CHECK_TIMER, false);
            timerService.createIntervalTimer(INITIAL_TIMEOUT, CHECK_INTERVAL, config2);
        } catch (IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Timeout
    public void timeout(Timer timer) {
        Serializable timerHit = timer.getInfo();
        System.out.println("TimeHit: " + timerHit);
    }
}
