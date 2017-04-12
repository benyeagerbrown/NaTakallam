package com.globalappinitiative.natakallam;


class UserDataInstance {
    private static UserData userDataInstance;

    static UserData get() {
        return userDataInstance;
    }

    static void set(UserData userData) {
        userDataInstance = userData;
    }
}
