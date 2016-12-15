package com.vel9.generativemusic.core.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    private static final String APP_LOGGER = "AppLogger";
    private static final Logger applogger = Logger.getLogger(APP_LOGGER);

    static {
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        applogger.addHandler(handler);
        applogger.setLevel(Level.ALL);
    }

    public static void log(Level level, String tag, String message){
        applogger.log(level, tag + "; " + message);
    }

    public static void config(String tag, Object value){
        applogger.log(Level.CONFIG, tag + "; " + value);
    }

}