package com.globalappinitiative.natakallam;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                }
                else if (tabId == R.id.tab_payments) {
                    Toast.makeText(getApplicationContext(), "Payments", Toast.LENGTH_SHORT).show();
                }
                else if (tabId == R.id.tab_profile) {
                    Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                }
                else if (tabId == R.id.tab_settings) {
                    Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
