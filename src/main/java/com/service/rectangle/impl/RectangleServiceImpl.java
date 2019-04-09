package com.service.impl;

import com.cache.Cache;
import com.entity.Parameters;
import com.errorPages.BadRequestError;
import com.entity.Rectangle;
import com.service.RectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RectangleServiceImpl implements RectangleService {

    private Cache cache;

    @Autowired
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

        Parameters parameters = new Parameters(length,width);

        if(cache.containKey(parameters))
            return cache.get(parameters);

        int squre = Integer.parseInt(length) * Integer.parseInt(width);
        int perimetr = 2 * (Integer.parseInt(length) + Integer.parseInt(width));

        Rectangle rectangle = new Rectangle(String.valueOf(squre),String.valueOf(perimetr));
        cache.put(parameters,rectangle);

        if(length.contains("3"))
            System.out.println("ky");

        return rectangle;
    }

}
