package com.saper.primeiro.dtos;

public class PriceResponseDTO {
    public double car;

    public double motorcycle;

    public PriceResponseDTO(double car, double motorcycle) {
        this.car = car;
        this.motorcycle = motorcycle;
    }
}
