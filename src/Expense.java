package com.Tracker;

public class Expense {
    private String item;
    private String date;
    private float cost;

    public Expense(String item, String date, float cost) {
        this.item = item;
        this.date = date;
        this.cost = cost;
    }

    public String getItem() {
        return item;
    }

    public String getDate() {
        return date;
    }

    public float getCost() {
        return cost;
    }
}
