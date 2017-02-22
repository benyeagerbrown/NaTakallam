package com.globalappinitiative.natakallam;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;

public class AddSessionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);

        Spinner month_spinner = (Spinner) findViewById(R.id.month_spinner);

        ArrayAdapter<CharSequence> month_adapter = ArrayAdapter.createFromResource(this,
                R.array.month_array, android.R.layout.simple_spinner_item);

        month_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        month_spinner.setAdapter(month_adapter);


        Spinner day_spinner = (Spinner) findViewById(R.id.day_spinner);

        ArrayAdapter<CharSequence> day_adapter = ArrayAdapter.createFromResource(this,
                R.array.day_array, android.R.layout.simple_spinner_item);

        day_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        day_spinner.setAdapter(day_adapter);

    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        }

        public void onNothingSelected(AdapterView<?> parent) {

        }

    }




}
