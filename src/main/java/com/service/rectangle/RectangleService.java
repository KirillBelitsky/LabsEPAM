package com.service.rectangle;

import com.entity.Parameters;
import com.entity.Rectangle;

import java.util.List;

public interface RectangleService {
    boolean validate(String length,String width);
    Rectangle process(String length,String width);
    List<Rectangle> processList(List<Parameters> list);
}
