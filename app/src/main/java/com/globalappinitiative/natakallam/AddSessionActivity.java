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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AddSessionActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private static final String book_session_url = "http://natakallam.eastus.cloudapp.azure.com/api/sessions/book?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);

        final java.util.Calendar c = java.util.Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d", Locale.ENGLISH);
        String formattedDate = dateFormat.format(c.getTime());

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);

        if (android.text.format.DateFormat.is24HourFormat(this)) {
            timeFormat.applyPattern("k:mm");
        }

        String formattedTime = timeFormat.format(c.getTime());

        Button time_button = (Button) findViewById(R.id.time_button);
        time_button.setText(formattedTime);

        Button date_button = (Button) findViewById(R.id.date_button);
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


    java.util.Calendar sessionDateTime = java.util.Calendar.getInstance();

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        Button time_button = (Button) findViewById(R.id.time_button);

        sessionDateTime.set(Calendar.HOUR_OF_DAY, hour);
        sessionDateTime.set(Calendar.MINUTE, minute);

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);

        if (android.text.format.DateFormat.is24HourFormat(this)) {
            timeFormat.applyPattern("k:mm");
        }

        String formattedTime = timeFormat.format(sessionDateTime.getTime());

        time_button.setText(formattedTime);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Button date_button = (Button) findViewById(R.id.date_button);

        sessionDateTime.set(Calendar.YEAR, year);
        sessionDateTime.set(Calendar.MONTH, month);
        sessionDateTime.set(Calendar.DAY_OF_MONTH, day);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d", Locale.ENGLISH);
        String formattedDate = dateFormat.format(sessionDateTime.getTime());

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

    public void confirmSession(View v) {

        final java.util.Calendar now = java.util.Calendar.getInstance();

        if (sessionDateTime.before(now)) {
            showDialog("Must schedule sessions in the future");
            return;
        }

        SimpleDateFormat finalDateFormat = new SimpleDateFormat("yyyy-M-dd kk:mm:ss", Locale.ENGLISH);

        String user_id = User.getValue(User.Keys.id, this);
        String cp_id = "4";
        String lang_id = "1";
        String scheduled_at = finalDateFormat.format(sessionDateTime.getTime());
        String credit_amount = "1";
        String is_premium = "false";

        final String book_session_url_with_params = book_session_url +
                "user_id=" + user_id +
                "&cp_id=" + cp_id +
                "&lang_id" + lang_id +
                "&scheduled_at" + scheduled_at +
                "&credit_amount" + credit_amount +
                "&is_premium" + is_premium;


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, book_session_url_with_params, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    boolean isError = response.getBoolean("errors");
                    if(isError) {
                        JSONObject errors = response.getJSONObject("errors");
                        String message = errors.getString("message");
                        showDialog(message);
                    }
                    else {
                        showDialog(response.getString("data"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    showDialog(getString(R.string.books_session_error));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                //showDialog(getString(R.string.books_session_error));
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                String token = User.getValue(User.Keys.token, getApplicationContext());
                params.put("Authorization", "Bearer " + token);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

        finish();
    }


}



