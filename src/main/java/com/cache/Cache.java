package com.cache;

import com.entity.Parameters;
import com.entity.Rectangle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class Cache {

    private HashMap<Parameters, Rectangle> map;

    public Cache(){
        map = new HashMap<>();
    }

    public void put(Parameters key,Rectangle rectangle){
        map.put(key, rectangle);
    }

    public Rectangle get(Parameters key){
        return map.get(key);
    }

    public boolean containKey(Parameters key){
        if(map.size() == 0)
            return false;

        Set<Parameters> keys = map.keySet();
        return keys.contains(key);
    }
}
