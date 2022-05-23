package com.example.projetorestaurante.models;

import java.io.Serializable;

public class Item implements Serializable {
    private int code;
    private String description;
    private String observation;
    private double price;

    public Item(int code, String description, String observation, double price) {
        this.code = code;
        this.description = description;
        this.observation = observation;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
