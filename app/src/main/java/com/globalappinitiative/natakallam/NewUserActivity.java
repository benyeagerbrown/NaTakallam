package com.globalappinitiative.natakallam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUsernameNew;
    EditText editTextPasswordNew;
    EditText editTextPasswordConfirm;
    Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        editTextUsernameNew = (EditText) findViewById(R.id.editTextUsernameNew);
        editTextPasswordNew = (EditText) findViewById(R.id.editTextPasswordNew);
        editTextPasswordConfirm = (EditText) findViewById(R.id.editTextPasswordConfirm);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonSignUp.getId()) {
            // check if username not taken, create an account for this user
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
