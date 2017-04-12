
package com.globalappinitiative.natakallam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CpRequest {

    @SerializedName("language")
    @Expose
    private Language__ language;
    @SerializedName("fulfilled")
    @Expose
    private Integer fulfilled;
    @SerializedName("requested_at")
    @Expose
    private RequestedAt requestedAt;
    @SerializedName("updated_at")
    @Expose
    private UpdatedAt_____ updatedAt;

    public Language__ getLanguage() {
        return language;
    }

    public void setLanguage(Language__ language) {
        this.language = language;
    }

    public Integer getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(Integer fulfilled) {
        this.fulfilled = fulfilled;
    }

    public RequestedAt getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(RequestedAt requestedAt) {
        this.requestedAt = requestedAt;
    }

    public UpdatedAt_____ getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(UpdatedAt_____ updatedAt) {
        this.updatedAt = updatedAt;
    }

}
