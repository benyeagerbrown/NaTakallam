package com.globalappinitiative.natakallam;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.DialogFragment;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddSessionActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);

        final java.util.Calendar c = java.util.Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d", Locale.ENGLISH);
        String formattedDate = dateFormat.format(c.getTime());

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);

        if(android.text.format.DateFormat.is24HourFormat(this)) {
            timeFormat.applyPattern("k:mm");
        }


        String formattedTime = timeFormat.format(c.getTime());

        Button time_button = (Button)findViewById(R.id.time_button);
        time_button.setText(formattedTime);

        Button date_button = (Button)findViewById(R.id.date_button);
        date_button.setText(formattedDate);


    }

    public void showDatePickerDialog(View v) {

        final java.util.Calendar c = java.util.Calendar.getInstance();

        int year = c.get(java.util.Calendar.YEAR);
        int month = c.get(java.util.Calendar.MONTH);
        int day = c.get(java.util.Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(AddSessionActivity.this, this, year, month, day);
        datePicker.show();
    }

    public void showTimePickerDialog(View v) {
        final java.util.Calendar c = java.util.Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePicker = new TimePickerDialog(AddSessionActivity.this, this, hour, minute, false);
        timePicker.show();

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        Button time_button = (Button)findViewById(R.id.time_button);

        final java.util.Calendar now = java.util.Calendar.getInstance();

        java.util.Calendar c = java.util.Calendar.getInstance();
        c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), hour, minute);

        if(c.before(now)) {
            showDialog("Must schedule sessions in the future");
            return;
        }

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);

        if(android.text.format.DateFormat.is24HourFormat(this)) {
            timeFormat.applyPattern("k:mm");
        }

        String formattedTime = timeFormat.format(c.getTime());

        time_button.setText(formattedTime);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Button date_button = (Button)findViewById(R.id.date_button);

        final java.util.Calendar now = java.util.Calendar.getInstance();

        java.util.Calendar c = java.util.Calendar.getInstance();
        c.set(year, month, day);

        if(c.before(now)) {
            showDialog("Must schedule sessions in the future");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d", Locale.ENGLISH);
        String formattedDate = dateFormat.format(c.getTime());

        date_button.setText(formattedDate);



    }

    public void showDialog(String message) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok), null)
                .show();
    }
    public void returnHome(View v) {
        finish();
    }
}



