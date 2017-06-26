package com.bboniao.util.random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;

/**
 *
 * Created by guhb on 26/06/2017.
 */
public final class Random {

    private Random(){}

    public static String randomNumeric(int count) {
        return new RandomStringGenerator.Builder().withinRange('0', '9').build().generate(count);
    }
}
