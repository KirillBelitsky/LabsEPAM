package com.service.rectangle;

import com.entity.*;

import java.util.List;

public interface RectangleService {
    boolean validate(String length,String width);
    Rectangle process(String length,String width);
    List<Rectangle> processList(List<Parameters> list);
    ResultStatistic calculateStatistic(List<Parameters> list);
    List<CacheResult> getAll();
}
