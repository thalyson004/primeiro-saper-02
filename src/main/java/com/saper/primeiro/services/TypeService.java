package com.saper.primeiro.services;

import org.springframework.stereotype.Component;

@Component
public class TypeService {
    public double calcType(String type){
        if(type.equals("moto")){
            return 1.0;
        }else{
            return 1.5;
        }
    }
}
