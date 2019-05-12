package com.service.rectangle.impl;

import com.cache.Cache;
import com.entity.*;
import com.repository.CacheRepository;
import com.service.counter.CounterService;
import com.service.rectangle.RectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RectangleServiceImpl implements RectangleService {

    private static final Logger logger = Logger.getLogger(RectangleServiceImpl.class);
    private Cache cache;
    private CounterService counterService;
    private CacheRepository cacheRepository;

    @PostConstruct
    void init(){

        cacheRepository.findAll().forEach(value->{
            Parameters parameters = new Parameters(value.getLength(),value.getWidth());
            Rectangle rectangle = new Rectangle(value.getSquare(),value.getPerimeter());

            cache.put(parameters,rectangle);
            logger.info("Add " + rectangle.toString() + "at cache!");
        });
    }

    @Autowired
    public RectangleServiceImpl(Cache cache, CounterService counterService,CacheRepository cacheRepository) {
        this.cache = cache;
        this.counterService = counterService;
        this.cacheRepository = cacheRepository;
    }

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
    public synchronized Rectangle process(String length, String width) {

        counterService.increment();
        logger.debug("This service was used " + counterService.getCounter());

        Parameters parameters = new Parameters(length, width);

        if (cache.containKey(parameters))
            return cache.get(parameters);

        int squre = Integer.parseInt(length) * Integer.parseInt(width);
        int perimetr = 2 * (Integer.parseInt(length) + Integer.parseInt(width));

        Rectangle rectangle = new Rectangle(String.valueOf(squre), String.valueOf(perimetr));
        cache.put(parameters, rectangle);

        return rectangle;
    }

    @Override
    public List<Rectangle> processList(List<Parameters> list) {

        return list.stream().filter(value -> {
            int length = Integer.parseInt(value.getLength());
            int width = Integer.parseInt(value.getWidth());

            return width > 0 && length > 0;
        }).map(value -> {

            logger.info("We are in stream map!");

            if(cache.containKey(value)){
                logger.info("Get result from cache " + cache.get(value).toString());
                return cache.get(value);
            }

            CacheResult cacheResult = new CacheResult();

            int perimeter = 2 * (Integer.parseInt(value.getWidth()) + Integer.parseInt(value.getLength()));
            int square = Integer.parseInt(value.getLength()) * Integer.parseInt(value.getWidth());

            Rectangle rectangle = new Rectangle(String.valueOf(square), String.valueOf(perimeter));

            cacheResult.setLength(value.getLength());
            cacheResult.setWidth(value.getWidth());
            cacheResult.setPerimeter(rectangle.getPerimeter());
            cacheResult.setSquare(rectangle.getSquare());

            logger.info("Add result in cache!");

            cacheRepository.save(cacheResult);
            cache.put(new Parameters(value.getLength(),value.getWidth()),rectangle);

            return rectangle;
        }).collect(Collectors.toList());
    }

    @Override
    public ResultStatistic calculateStatistic(List<Parameters> list) {
        Statistic statistic = new Statistic();
        List<Rectangle> resultList = this.processList(list);

        statistic.setAmountParameters(list.size());

        statistic.setAmountIncorrectParameters(list.stream().filter(value -> {
            int length = Integer.parseInt(value.getLength());
            int width = Integer.parseInt(value.getWidth());

            return width < 0 || length < 0;
        }).count());

        Optional<Rectangle> paramWithMinLength = resultList.stream().min(Comparator.comparingInt(value -> Integer.parseInt(value.getSquare())));
        statistic.setMin(Integer.parseInt(paramWithMinLength.get().getSquare()));

        Optional<Rectangle> paramWithMaxLength = resultList.stream().max(Comparator.comparingInt(value -> Integer.parseInt(value.getSquare())));
        statistic.setMax(Integer.parseInt(paramWithMaxLength.get().getSquare()));

        statistic.setPopularResult(findMostPopularResult(resultList));


        return new ResultStatistic(resultList,statistic);
    }

    private Rectangle findMostPopularResult(List<Rectangle> list){
        HashMap<Rectangle,Integer> map = new HashMap<>();

        list.forEach(value->{
            System.out.println(value.toString());
            if(map.containsKey(value)){
                map.replace(value,map.get(value) + 1);
            }
            else map.put(value,1);
        });

        Rectangle answer = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
        return answer;
    }

    public List<CacheResult> getAll(){
        return cacheRepository.findAll();
    }
}
