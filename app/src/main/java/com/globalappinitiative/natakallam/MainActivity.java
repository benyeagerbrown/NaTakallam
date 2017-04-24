package com.globalappinitiative.natakallam;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    static final int SIGN_IN = 0;
    static final int HOME_ID = 0;
    static final int PAYMENTS_ID = 1;
    static final int CALENDAR_ID = 2;
    static final int SETTINGS_ID = 3;
    int currentFragmentIndex = HOME_ID;
    static final String instanceKey = "currentFragmentIndex";

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            currentFragmentIndex = savedInstanceState.getInt(instanceKey);
        } else {
            //String isSignedIn = User.getValue(User.Keys.signedIn, this);
            //if (!isSignedIn.equals("true")) {
                currentFragmentIndex = HOME_ID;
                startActivityForResult(new Intent(this, SignInActivity.class), SIGN_IN);
            //}
        }

        changeFragment(currentFragmentIndex);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    changeFragment(HOME_ID);
                    changeColor(R.color.colorPrimary, R.color.colorPrimaryDark);
                } else if (tabId == R.id.tab_payments) {
                    changeFragment(PAYMENTS_ID);
                    changeColor(R.color.paymentsColor, R.color.paymentsColorDark);
                } else if (tabId == R.id.tab_calendar) {
                    changeFragment(CALENDAR_ID);
                    changeColor(R.color.calendarColor, R.color.calendarDark);
                } else if (tabId == R.id.tab_settings) {
                    changeFragment(SETTINGS_ID);
                    changeColor(R.color.settingsColor, R.color.settingsColorDark);
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SIGN_IN) {
            if (resultCode == RESULT_OK) {
                changeFragment(currentFragmentIndex);
            } else if (resultCode == RESULT_CANCELED) {
                finish();
            }
        }
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(instanceKey, currentFragmentIndex);
    }

    public void addSession(View v) {
        startActivity(new Intent(MainActivity.this, AddSessionActivity.class));
    }


    public void openProfile(View v) {
        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
    }

    private void changeColor(int toolbarColor, int notificationColor) {
        toolbar.setBackgroundColor(getColor(toolbarColor));
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, notificationColor));
    }

    private void changeFragment(int currentFragmentIndex) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        switch (currentFragmentIndex) {
            case HOME_ID:
                ft.replace(R.id.contentContainer, new HomeFragment());
                break;
            case PAYMENTS_ID:
                ft.replace(R.id.contentContainer, new PaymentsFragment());
                break;
            case CALENDAR_ID:
                ft.replace(R.id.contentContainer, new CalendarFragment());
                break;
            default:
                ft.replace(R.id.contentContainer, new SettingsFragment());
                break;
        }
        ft.commit();
        this.currentFragmentIndex = currentFragmentIndex;
    }

    public void loggedOut() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

}
