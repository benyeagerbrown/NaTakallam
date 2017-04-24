
package com.globalappinitiative.natakallam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TabooTopic {

    @SerializedName("topic")
    @Expose
    private String topic;
    @SerializedName("added_at")
    @Expose
    private AddedAt addedAt;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public AddedAt getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(AddedAt addedAt) {
        this.addedAt = addedAt;
    }

}
