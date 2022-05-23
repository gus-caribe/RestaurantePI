package com.example.projetorestaurante.models;

import java.io.Serializable;

public class Order implements Serializable {
    private int code;
    private String date;
    private String waiter;
    private int order;
    private double total;

    public Order(int code, String date, String waiter, int order, double total) {
        this.code = code;
        this.date = date;
        this.waiter = waiter;
        this.order = order;
        this.total = total;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
