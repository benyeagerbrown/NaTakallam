
package com.globalappinitiative.natakallam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("credit_balance")
    @Expose
    private Integer creditBalance;
    @SerializedName("credit_expiration_date")
    @Expose
    private String creditExpirationDate;
    @SerializedName("created_at")
    @Expose
    private CreatedAt___ createdAt;
    @SerializedName("updated_at")
    @Expose
    private UpdatedAt___ updatedAt;

    public Integer getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(Integer creditBalance) {
        this.creditBalance = creditBalance;
    }

    public String getCreditExpirationDate() {
        return creditExpirationDate;
    }

    public void setCreditExpirationDate(String creditExpirationDate) {
        this.creditExpirationDate = creditExpirationDate;
    }

    public CreatedAt___ getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(CreatedAt___ createdAt) {
        this.createdAt = createdAt;
    }

    public UpdatedAt___ getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(UpdatedAt___ updatedAt) {
        this.updatedAt = updatedAt;
    }

}
