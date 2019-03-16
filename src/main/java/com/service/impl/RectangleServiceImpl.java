package com.service.impl;

import com.errorPages.BadRequestError;
import com.entity.Rectangle;
import com.service.RectangleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class RectangleServiceImpl implements RectangleService {

    @Override
    public boolean validate(String length, String width) {

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

        int squre = Integer.parseInt(length) * Integer.parseInt(width);
        int perimetr = 2 * (Integer.parseInt(length) + Integer.parseInt(width));

        return new Rectangle(String.valueOf(squre),String.valueOf(perimetr));
    }
}