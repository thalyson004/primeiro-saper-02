package com.saper.primeiro.services;

import org.springframework.stereotype.Component;

@Component
public class TimeService {

    public double calcTime(int minutes){
        if(minutes <= 10){
            return 0;
        }else {
            return Math.ceil(minutes/15.0);
        }
    }
}
