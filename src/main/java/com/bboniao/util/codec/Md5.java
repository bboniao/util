package com.bboniao.util.codec;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 *
 * Created by guhb on 26/06/2017.
 */
public final class Md5 {

    @SuppressWarnings("deprecation")
    private static HashFunction hf = Hashing.md5();
    private static Charset defaultCharset = Charset.forName("UTF-8");

    private Md5(){}

    public static String md5(String data) {
        HashCode hash = hf.newHasher().putString(data, defaultCharset).hash();
        return hash.toString();
    }
}
