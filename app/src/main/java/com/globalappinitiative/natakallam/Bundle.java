
package com.globalappinitiative.natakallam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bundle {

    @SerializedName("bundle_name")
    @Expose
    private BundleName bundleName;
    @SerializedName("credits_used")
    @Expose
    private Object creditsUsed;
    @SerializedName("is_voucher")
    @Expose
    private Integer isVoucher;
    @SerializedName("activation_date")
    @Expose
    private Object activationDate;
    @SerializedName("created_at")
    @Expose
    private CreatedAt__ createdAt;
    @SerializedName("updated_at")
    @Expose
    private UpdatedAt__ updatedAt;

    public BundleName getBundleName() {
        return bundleName;
    }

    public void setBundleName(BundleName bundleName) {
        this.bundleName = bundleName;
    }

    public Object getCreditsUsed() {
        return creditsUsed;
    }

    public void setCreditsUsed(Object creditsUsed) {
        this.creditsUsed = creditsUsed;
    }

    public Integer getIsVoucher() {
        return isVoucher;
    }

    public void setIsVoucher(Integer isVoucher) {
        this.isVoucher = isVoucher;
    }

    public Object getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Object activationDate) {
        this.activationDate = activationDate;
    }

    public CreatedAt__ getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(CreatedAt__ createdAt) {
        this.createdAt = createdAt;
    }

    public UpdatedAt__ getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(UpdatedAt__ updatedAt) {
        this.updatedAt = updatedAt;
    }

}
