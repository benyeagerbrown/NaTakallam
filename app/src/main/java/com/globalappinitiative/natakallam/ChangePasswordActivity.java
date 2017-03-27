package com.globalappinitiative.natakallam;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextCurrentPassword;
    private EditText editTextNewPassword;
    private EditText editTextConfirmNewPassword;
    private Button buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        editTextCurrentPassword = (EditText) findViewById(R.id.editTextCurrentPassword);
        editTextNewPassword = (EditText) findViewById(R.id.editTextNewPassword);
        editTextConfirmNewPassword = (EditText) findViewById(R.id.editTextConfirmNewPassword);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == buttonUpdate.getId()) {
            if (checkPassword()) {
                if (arePasswordsSame()) {
                    setNewPassword();
                    finish();
                } else {
                    showDialog(getString(R.string.mismatched_passwords));
                }
            } else {
                showDialog(getString(R.string.incorrect_password));
            }
        }
    }

    private void showDialog(String message) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok), null)
                .show();
    }

    private boolean checkPassword() {
        return editTextCurrentPassword.getText().toString().equals("password");
    }


    private boolean arePasswordsSame() {
        return editTextNewPassword.getText().toString().equals(editTextConfirmNewPassword.getText().toString());
    }

    private void setNewPassword() {

    }
}
