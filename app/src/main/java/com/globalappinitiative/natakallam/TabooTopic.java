package com.globalappinitiative.natakallam;


class TabooTopic {
    private String topic;
    private String description;

    public TabooTopic(String topic, String description) {
        this.topic = topic;
        this.description = description;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getDescription() {
        return this.description;
    }
}
