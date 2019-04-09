package com.service.rectangle.impl;

import com.cache.Cache;
import com.entity.Parameters;
import com.entity.Rectangle;
import com.service.counter.CounterService;
import com.service.rectangle.RectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

@Service
public class RectangleServiceImpl implements RectangleService {

    private static final Logger logger = Logger.getLogger(RectangleServiceImpl.class);
    private Cache cache;
    private CounterService counterService;

    @Autowired
    public RectangleServiceImpl(Cache cache,CounterService counterService){
        this.cache = cache;
        this.counterService = counterService;
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
    public synchronized Rectangle process(String length, String width) {

        counterService.increment();
        logger.debug("This service was used " + counterService.getCounter());

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
