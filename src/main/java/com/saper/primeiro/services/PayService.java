package com.saper.primeiro.services;

import org.springframework.stereotype.Component;

@Component
public class PayService {
    TypeService typeService;
    TimeService timeService;

    public PayService(TypeService typeService, TimeService timeService) {
        this.typeService = typeService;
        this.timeService = timeService;
    }

    public double calcCost(int minutes, String type){
        return typeService.calcType(type)*timeService.calcTime(minutes);
    }

}
