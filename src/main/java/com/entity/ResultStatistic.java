package com.entity;

import java.util.List;

public class ResultStatistic {

    private Statistic statistic;
    private List<Rectangle> answers;

    public ResultStatistic(List<Rectangle> answers,Statistic statistic) {
        this.statistic = statistic;
        this.answers = answers;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    public List<Rectangle> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Rectangle> answers) {
        this.answers = answers;
    }
}
