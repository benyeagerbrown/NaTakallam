
package com.globalappinitiative.natakallam;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("free_times")
    @Expose
    private List<FreeTime> freeTimes = null;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("taboo_topics")
    @Expose
    private List<TabooTopic> tabooTopics = null;
    @SerializedName("lang_skills")
    @Expose
    private List<LangSkill> langSkills = null;
    @SerializedName("langs_to_learn")
    @Expose
    private List<LangsToLearn> langsToLearn = null;
    @SerializedName("bundles")
    @Expose
    private List<Bundle> bundles = null;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("cps")
    @Expose
    private List<Cp> cps = null;
    @SerializedName("cp_requests")
    @Expose
    private List<CpRequest> cpRequests = null;
    @SerializedName("token")
    @Expose
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<FreeTime> getFreeTimes() {
        return freeTimes;
    }

    public void setFreeTimes(List<FreeTime> freeTimes) {
        this.freeTimes = freeTimes;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<TabooTopic> getTabooTopics() {
        return tabooTopics;
    }

    public void setTabooTopics(List<TabooTopic> tabooTopics) {
        this.tabooTopics = tabooTopics;
    }

    public List<LangSkill> getLangSkills() {
        return langSkills;
    }

    public void setLangSkills(List<LangSkill> langSkills) {
        this.langSkills = langSkills;
    }

    public List<LangsToLearn> getLangsToLearn() {
        return langsToLearn;
    }

    public void setLangsToLearn(List<LangsToLearn> langsToLearn) {
        this.langsToLearn = langsToLearn;
    }

    public List<Bundle> getBundles() {
        return bundles;
    }

    public void setBundles(List<Bundle> bundles) {
        this.bundles = bundles;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Cp> getCps() {
        return cps;
    }

    public void setCps(List<Cp> cps) {
        this.cps = cps;
    }

    public List<CpRequest> getCpRequests() {
        return cpRequests;
    }

    public void setCpRequests(List<CpRequest> cpRequests) {
        this.cpRequests = cpRequests;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
