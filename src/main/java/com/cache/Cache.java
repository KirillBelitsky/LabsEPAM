package com.cache;

import com.entity.Rectangle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class Cache {

    private HashMap<String, Rectangle> map;

    public Cache(){
        map = new HashMap<>();
    }

    public void put(String key,Rectangle rectangle){
        map.put(key, rectangle);
    }

    public Rectangle get(String key){
        return map.get(key);
    }

    public boolean containKey(String key){
        if(map.size() == 0)
            return false;

        Set<String> keys = map.keySet();
        return keys.contains(key);
    }
}
