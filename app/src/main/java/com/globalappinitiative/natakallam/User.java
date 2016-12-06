package com.globalappinitiative.natakallam;

/**
 * Created by Ben on 11/30/2016.
 */

public class User {

    // User Profile Class, containing all the data that might be sent to or received from the API

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String gender;
    private String password;
    private String skype_id;
    private String avatar_file_name;
    private String short_bio;
    private String heard_about_us_from;
    private String extra_details;
    private String hobbies;
    private String profession;
    private String time_zone;
    private String title;
    private String dob;

    public User(String first_name, String last_name, String email, String phone_number, String gender, String password) {
        // Constructor for creating a new user
        // Parameters are only required fields for registration

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.gender = gender;
        this.password = password;

        this.skype_id = null;
        this.avatar_file_name = null;
        this.short_bio = null;
        this.heard_about_us_from = null;
        this.extra_details = null;
        this.hobbies = null;
        this.profession = null;
        this.time_zone = null;
        this.title = null;
        this.dob = null;

    }

    public void setId(int id) { this.id = id; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public void setEmail(String email) { this.email = email; }

    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    public void setGender(String gender) { this.gender = gender; }

    public void setPassword(String password) { this.password = password; }

    public void setSkype_id(String skype_id) { this.skype_id = skype_id; }

    public void setAvatar_file_name(String avatar_file_name) { this.avatar_file_name = avatar_file_name; }

    public void setShort_bio(String short_bio) { this.short_bio = short_bio; }

    public void setHeard_about_us_from(String heard_about_us_from) { this.heard_about_us_from = heard_about_us_from; }

    public void setExtra_details(String extra_details) { this.extra_details = extra_details; }

    public void setHobbies(String hobbies) { this.hobbies = hobbies; }

    public void setProfession(String profession) { this.profession = profession; }

    public void setTime_zone(String time_zone) { this.time_zone = time_zone; }

    public void setTitle(String title) { this.title = title; }

    public void setDob(String dob) { this.dob = dob; }

    public int getId() { return this.id; }

    public String getFirst_name() { return this.first_name; }

    public String getLast_name() { return this.last_name; }

    public String getEmail() { return this.email; }

    public String getPhone_number() { return this.phone_number; }

    public String getGender() { return this.gender; }

    public String getPassword() { return this.password; }

    public String getSkype_id() { return this.skype_id; }

    public String getAvatar_file_name() { return this.avatar_file_name; }

    public String getShort_bio() { return this.short_bio; }

    public String getHeard_about_us_from() { return this.heard_about_us_from; }

    public String getExtra_details() { return this.extra_details; }

    public String getHobbies() { return this.hobbies; }

    public String getProfession() { return this.profession; }

    public String getTime_zone() { return this.time_zone; }

    public String getTitle() { return this.title; }

    public String getDob() { return this.dob; }

}
