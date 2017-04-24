
package com.globalappinitiative.natakallam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cp {

    @SerializedName("cp")
    @Expose
    private Cp_ cp;
    @SerializedName("teaches")
    @Expose
    private Teaches teaches;
    @SerializedName("added_at")
    @Expose
    private AddedAt_ addedAt;
    @SerializedName("updated_at")
    @Expose
    private UpdatedAt____ updatedAt;

    public Cp_ getCp() {
        return cp;
    }

    public void setCp(Cp_ cp) {
        this.cp = cp;
    }

    public Teaches getTeaches() {
        return teaches;
    }

    public void setTeaches(Teaches teaches) {
        this.teaches = teaches;
    }

    public AddedAt_ getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(AddedAt_ addedAt) {
        this.addedAt = addedAt;
    }

    public UpdatedAt____ getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(UpdatedAt____ updatedAt) {
        this.updatedAt = updatedAt;
    }

}
