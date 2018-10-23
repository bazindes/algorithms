package com.baz.app.lc.medium;

import com.baz.app.Interface.Google.Google;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL implements Google {

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
