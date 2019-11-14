package com.capgemini.tdd.demo.models;

import com.capgemini.tdd.demo.services.NumberService;

public class TalkyNumber {
    private final long id;
    private final int number;
    private NumberService talkynumbers = new NumberService();

    public TalkyNumber(long id, int number) {
        this.id = id;
        this.number= number;
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return talkynumbers.convert(number);
    }
}


