package com.vel9.generativemusic.core.util;

import com.vel9.generativemusic.core.support.Constants;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by levani on 12/7/16.
 */
public class Util {
    // ref: http://stackoverflow.com/a/363692
    public static int getRandom(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int getSeconds(int numSeconds){
        return Constants.SECOND_IN_MILLIS * numSeconds;
    }
}