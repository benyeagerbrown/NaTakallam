package com.globalappinitiative.natakallam;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.DialogFragment;

public class AddSessionActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new AddDateFragment();
        newFragment.show(getFragmentManager(), "addDate");
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new AddTimeFragment();
        newFragment.show(getFragmentManager(), "addTime");
    }

}



