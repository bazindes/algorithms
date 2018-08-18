package com.baz.app.google.medium;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

    Map<Integer, String> map = new HashMap<>();
    String host = "http://tiny/";

    public String encode(String longUrl){
        Integer hash = longUrl.hashCode();
        map.put(hash , longUrl);
        return host + hash;
    }

    public String decode(String shortUrl){
        return  map.get(Integer.parseInt(shortUrl.replace(host, "")));
    }

}
