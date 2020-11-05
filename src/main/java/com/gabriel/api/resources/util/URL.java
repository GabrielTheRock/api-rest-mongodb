package com.gabriel.api.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/*
 * Para realizar a query, preciso decodificar o parâmetro passado no endpoint
 */
public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
