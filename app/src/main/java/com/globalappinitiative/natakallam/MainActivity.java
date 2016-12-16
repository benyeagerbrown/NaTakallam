package com.globalappinitiative.natakallam;


import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
                    android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.contentContainer, new HomeFragment());
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                } else if (tabId == R.id.tab_payments) {
                    android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.contentContainer, new PaymentsFragment());
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                } else if (tabId == R.id.tab_profile) {
                    android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.contentContainer, new ProfileFragment());
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                } else if (tabId == R.id.tab_settings) {
                    android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.contentContainer, new SettingsFragment());
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                }
            }
        });
    }
}
