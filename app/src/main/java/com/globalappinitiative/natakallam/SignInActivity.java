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
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

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
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, sign_in_url_with_params, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    boolean isError = response.getBoolean("errors");
                    if (isError) {
                        signInError();
                    } else {
                        JSONObject data = response.getJSONObject("data");
                        JSONObject user = data.getJSONObject("user");
                        User.setValue(User.Keys.id, Integer.toString(user.getInt(User.Keys.id)), getApplicationContext());
                        User.setValue(User.Keys.first_name, user.getString(User.Keys.first_name), getApplicationContext());
                        User.setValue(User.Keys.last_name, user.getString(User.Keys.last_name), getApplicationContext());
                        User.setValue(User.Keys.email, user.getString(User.Keys.email), getApplicationContext());
                        User.setValue(User.Keys.avatar_file_name, user.getString(User.Keys.avatar_file_name), getApplicationContext());
                        User.setValue(User.Keys.phone_number, user.getString(User.Keys.phone_number), getApplicationContext());
                        User.setValue(User.Keys.skype_id, user.getString(User.Keys.skype_id), getApplicationContext());
                        User.setValue(User.Keys.dob, user.getString(User.Keys.dob), getApplicationContext());
                        User.setValue(User.Keys.title, user.getString(User.Keys.title), getApplicationContext());
                        User.setValue(User.Keys.profession, user.getString(User.Keys.profession), getApplicationContext());
                        User.setValue(User.Keys.gender, user.getString(User.Keys.gender), getApplicationContext());
                        User.setValue(User.Keys.hobbies, user.getString(User.Keys.hobbies), getApplicationContext());
                        User.setValue(User.Keys.short_bio, user.getString(User.Keys.short_bio), getApplicationContext());
                        User.setValue(User.Keys.heard_about_us_from, user.getString(User.Keys.heard_about_us_from), getApplicationContext());
                        User.setValue(User.Keys.extra_details, user.getString(User.Keys.extra_details), getApplicationContext());
                        User.setValue(User.Keys.timezone, user.getString(User.Keys.timezone), getApplicationContext());
                        User.setValue(User.Keys.type, user.getString(User.Keys.type), getApplicationContext());
                        User.setValue(User.Keys.token, data.getString(User.Keys.token), getApplicationContext());
                        User.setValue(User.Keys.signedIn, "true", getApplicationContext());
                        goHome();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    signInError();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                signInError();
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
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