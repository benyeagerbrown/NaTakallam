package com.globalappinitiative.natakallam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    static final int SIGN_UP = 1;
    static final String sign_in_base_url = "http://natakallam.eastus.cloudapp.azure.com/api/auth/login?";
    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonSignIn;
    Button buttonNeedsAccount;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
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
            signIn();
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

    public boolean isEmailValid() {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = editTextEmail.getText().toString();

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    private void signIn() {
        progressDialog = ProgressDialog.show(this, getString(R.string.signing_in), getString(R.string.please_wait), true);
        if (!isEmailValid()) {
            signInError();
            return;
        }
        final String sign_in_url_with_params = sign_in_base_url
                + "email=" + editTextEmail.getText().toString()
                + "&password=" + editTextPassword.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, sign_in_url_with_params, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                UserDataInstance.set(gson.fromJson(response, UserData.class));
                if (UserDataInstance.get().getErrors()) {
                    signInError();
                } else {
                    goHome();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                signInError();
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void signInError() {
        Toast.makeText(getApplicationContext(), getString(R.string.sign_in_error), Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
    }

    private void goHome() {
        progressDialog.dismiss();
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}