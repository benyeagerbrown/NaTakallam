package com.globalappinitiative.natakallam;

class Appointment {

    private String day;
    private String time;
    private String tutor;

    Appointment(String day, String time, String tutor) {
        this.day = day;
        this.time = time;
        this.tutor = tutor;
    }

    String getDay() {
        return this.day;
    }

    String getTime() {
        return this.time;
    }

    String getTutor() {
        return this.tutor;
    }
}
