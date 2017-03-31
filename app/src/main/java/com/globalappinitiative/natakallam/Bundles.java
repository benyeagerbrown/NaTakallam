package com.globalappinitiative.natakallam;


class Bundles {

    private String title;
    private String description;

    Bundles(String title, String description) {
        this.title = title;
        this.description = description;
    }

    String getTitle() {
        return this.title;
    }

    String getDescription() {
        return this.description;
    }
}
