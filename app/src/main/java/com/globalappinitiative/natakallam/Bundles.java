package com.globalappinitiative.natakallam;


class Bundles {

    private String name;
    private String description;
    private int creditAmount;
    private int price;
    private int durationInDays;

    Bundles(String name, String description, int creditAmount, int price, int durationInDays) {
        this.name = name;
        this.description = description;
        this.creditAmount = creditAmount;
        this.price = price;
        this.durationInDays = durationInDays;
    }

    String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }

    int getCreditAmount() {
        return this.creditAmount;
    }

    int getPrice() {
        return this.price;
    }

    int getDurationInDays() {
        return this.durationInDays;
    }
}
