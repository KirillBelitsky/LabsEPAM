package com.entity;

import com.entity.Rectangle;

public class Statistic {

    private long amountParameters;
    private long amountIncorrectParameters;
    private int max;
    private int min;
    private Rectangle popularResult;

    public long getAmountParameters() {
        return amountParameters;
    }

    public void setAmountParameters(long amountParameters) {
        this.amountParameters = amountParameters;
    }

    public long getAmountIncorrectParameters() {
        return amountIncorrectParameters;
    }

    public void setAmountIncorrectParameters(long amountIncorrectParameters) {
        this.amountIncorrectParameters = amountIncorrectParameters;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public Rectangle getPopularResult() {
        return popularResult;
    }

    public void setPopularResult(Rectangle popularResult) {
        this.popularResult = popularResult;
    }
}
