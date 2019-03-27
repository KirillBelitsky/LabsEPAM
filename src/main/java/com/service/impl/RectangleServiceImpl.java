package com.service.impl;

import com.cache.Cache;
import com.errorPages.BadRequestError;
import com.entity.Rectangle;
import com.service.RectangleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class RectangleServiceImpl implements RectangleService {

    private Cache cache;

    public RectangleServiceImpl(Cache cache){
        this.cache = cache;
    }


    @Override
    public boolean validate(String length, String width)  {

        if (length.trim().length() == 0 || width.trim().length() == 0)
            return false;

        else if (!(length.matches("-?\\d+") && width.matches("-?\\d+")))
            return false;

        else if (Integer.parseInt(length) <= 0 || Integer.parseInt(width) <= 0)
            return false;

        return true;
    }

    @Override
    public Rectangle process(String length, String width) {

        if(cache.containKey(transform(length,width)))
            return cache.get(transform(length,width));

        int squre = Integer.parseInt(length) * Integer.parseInt(width);
        int perimetr = 2 * (Integer.parseInt(length) + Integer.parseInt(width));

        Rectangle rectangle = new Rectangle(String.valueOf(squre),String.valueOf(perimetr));
        cache.put(transform(length,width),rectangle);

        return rectangle;
    }

    private String transform(String temp1,String temp2){
        return temp1 + "_" + temp2;
    }
}