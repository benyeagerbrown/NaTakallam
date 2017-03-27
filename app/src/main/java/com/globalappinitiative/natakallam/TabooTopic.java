package com.globalappinitiative.natakallam;


class TabooTopic {
    private String topic;
    private String description;

    TabooTopic(String topic, String description) {
        this.topic = topic;
        this.description = description;
    }

    String getTopic() {
        return this.topic;
    }

    String getDescription() {
        return this.description;
    }

    void setTopic(String topic) {
        this.topic = topic;
    }

    void setDescription(String description) {
        this.description = description;
    }
}
