package com.service.counter;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private long counter;

    public void increment(){
        counter++;
    }

    public long getCounter() {
        return counter;
    }
}
