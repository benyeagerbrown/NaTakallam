package com.globalappinitiative.natakallam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    static final int SIGN_UP = 1;

    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonSignIn;
    Button buttonNeedsAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(this);
        buttonNeedsAccount = (Button) findViewById(R.id.buttonNeedsAccount);
        buttonNeedsAccount.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == buttonSignIn.getId()) {
            // check if username and password are correct
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        } else if (view.getId() == buttonNeedsAccount.getId()) {
            startActivityForResult(new Intent(this, NewUserActivity.class), SIGN_UP);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SIGN_UP) {
            if (resultCode == RESULT_OK) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}