package com.service;

import com.entity.Rectangle;

public interface RectangleService {
    boolean validate(String length,String width);
    Rectangle process(String length,String width);
}