package com.globalappinitiative.natakallam;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeEmailActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNewEmail;
    private EditText editTextConfirmNewEmail;
    private EditText editTextPassword;
    private Button buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        editTextNewEmail = (EditText) findViewById(R.id.editTextNewEmail);
        editTextConfirmNewEmail = (EditText) findViewById(R.id.editTextConfirmNewEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == buttonUpdate.getId()) {
            if (areEmailsSame()) {
                if (isEmailValid()) {
                    if (checkPassword()) {
                        setNewEmail();
                        finish();
                    } else {
                        showDialog(getString(R.string.incorrect_password));
                    }
                } else {
                    showDialog(getString(R.string.invalid_email));
                }
            } else{
                showDialog(getString(R.string.mismatched_emails));
            }
        }

    }

    private boolean areEmailsSame() {
        return editTextNewEmail.getText().toString().equals(editTextConfirmNewEmail.getText().toString());
    }

    public boolean isEmailValid() {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = editTextConfirmNewEmail.getText().toString();

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    private void showDialog(String message) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok), null)
                .show();
    }

    private boolean checkPassword() {
        return editTextPassword.getText().toString().equals("password");
    }

    private void setNewEmail() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(User.Keys.email, editTextConfirmNewEmail.getText().toString());
        editor.apply();
    }
}
