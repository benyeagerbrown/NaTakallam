
package com.globalappinitiative.natakallam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LangsToLearn {

    @SerializedName("language")
    @Expose
    private Language_ language;
    @SerializedName("current_level")
    @Expose
    private String currentLevel;
    @SerializedName("years_of_colloquial_studies")
    @Expose
    private String yearsOfColloquialStudies;
    @SerializedName("dialect")
    @Expose
    private Object dialect;
    @SerializedName("special_program")
    @Expose
    private Object specialProgram;
    @SerializedName("preferred_method")
    @Expose
    private String preferredMethod;
    @SerializedName("created_at")
    @Expose
    private CreatedAt_ createdAt;
    @SerializedName("updated_at")
    @Expose
    private UpdatedAt_ updatedAt;

    public Language_ getLanguage() {
        return language;
    }

    public void setLanguage(Language_ language) {
        this.language = language;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getYearsOfColloquialStudies() {
        return yearsOfColloquialStudies;
    }

    public void setYearsOfColloquialStudies(String yearsOfColloquialStudies) {
        this.yearsOfColloquialStudies = yearsOfColloquialStudies;
    }

    public Object getDialect() {
        return dialect;
    }

    public void setDialect(Object dialect) {
        this.dialect = dialect;
    }

    public Object getSpecialProgram() {
        return specialProgram;
    }

    public void setSpecialProgram(Object specialProgram) {
        this.specialProgram = specialProgram;
    }

    public String getPreferredMethod() {
        return preferredMethod;
    }

    public void setPreferredMethod(String preferredMethod) {
        this.preferredMethod = preferredMethod;
    }

    public CreatedAt_ getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(CreatedAt_ createdAt) {
        this.createdAt = createdAt;
    }

    public UpdatedAt_ getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(UpdatedAt_ updatedAt) {
        this.updatedAt = updatedAt;
    }

}
