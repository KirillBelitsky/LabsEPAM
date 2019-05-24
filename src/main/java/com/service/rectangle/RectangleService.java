package com.service.rectangle;

import com.entity.*;

import java.util.List;

public interface RectangleService {
    boolean validate(String length,String width);
    Rectangle process(String length,String width);
    ResultStatistic calculateStatistic(List<Parameters> list);
    List<CacheResult> getAll();
    Integer asynchCalculate(List<Parameters> parameters);
    List<Rectangle> getAnswerById(String id);
}
