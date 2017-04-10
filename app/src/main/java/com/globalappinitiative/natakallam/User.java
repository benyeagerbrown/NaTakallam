package com.globalappinitiative.natakallam;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

class User {

    // User Profile Class, containing all the data that might be sent to or received from the API

    static void setValue(String key, String value, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putString(key, value);
        sharedPreferencesEditor.apply();
    }

    static String getValue(String key, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(key, key);
    }

    class Keys {
        static final String id = "id";
        static final String first_name = "first_name";
        static final String last_name = "last_name";
        static final String email = "email";
        static final String avatar_file_name = "avatar_file_name";
        static final String phone_number = "phone_number";
        static final String skype_id = "skype_id";
        static final String dob = "dob";
        static final String title = "title";
        static final String profession = "profession";
        static final String gender = "gender";
        static final String hobbies = "hobbies";
        static final String short_bio = "short_bio";
        static final String heard_about_us_from = "heard_about_us_from";
        static final String extra_details = "extra_details";
        static final String timezone = "timezone";
        static final String type = "type";
        static final String token = "token";

        static final String password = "password";
        static final String taboo_topics = "taboo_topics";
        static final String about_us = "about_us";
        static final String log_out = "log_out";
    }
}
