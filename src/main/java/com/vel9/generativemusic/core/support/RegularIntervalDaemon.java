package com.vel9.generativemusic.core.support;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by levani on 12/8/16.
 */
public class RegularIntervalDaemon {

    // interval in millis
    private int interval;
    private DaemonCallback callback;

    public RegularIntervalDaemon(DaemonCallback callback, int interval){
        this.interval = interval;
        this.callback = callback;
    }

    public void start(){
        Timer timer = new Timer();
        timer.schedule(new RegularIntervalDaemon.Task(timer), 0);
    }

    private class Task extends TimerTask {
        private Timer timer;

        public Task(Timer timer){
            this.timer = timer;
        }

        @Override
        public void run(){
            callback.call();
            timer.schedule(new RegularIntervalDaemon.Task(timer), RegularIntervalDaemon.this.interval);
        }
    }
}
