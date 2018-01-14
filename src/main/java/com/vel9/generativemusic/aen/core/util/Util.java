package com.vel9.generativemusic.aen.core.util;

import com.vel9.generativemusic.aen.core.support.Constants;

import java.util.concurrent.ThreadLocalRandom;

/* helper utilities for common use throughout app */
public class Util {
    // ref: http://stackoverflow.com/a/363692
    public static int getRandom(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int getSeconds(int numSeconds){
        return Constants.SECOND_IN_MILLIS * numSeconds;
    }

    public static void state(boolean expression, String message){
        if (!expression){
            throw new IllegalStateException(message);
        }
    }

}
