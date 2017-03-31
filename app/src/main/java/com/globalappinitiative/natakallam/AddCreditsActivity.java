package com.globalappinitiative.natakallam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class AddCreditsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    View paymentsCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_credits);

        paymentsCircle = findViewById(R.id.paymentsCircle);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Bundles> bundleList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            bundleList.add(new Bundles("Bundle " + Integer.toString(i), "Description"));
        }

        RecyclerAdapterBundles recyclerAdapterBundles = new RecyclerAdapterBundles(bundleList);
        recyclerView.setAdapter(recyclerAdapterBundles);

        Animation scale_up_full_screen = AnimationUtils.loadAnimation(this, R.anim.scale_up_full_screen);
        scale_up_full_screen.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                recyclerView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                recyclerView.setVisibility(View.VISIBLE);
                recyclerView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
                paymentsCircle.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        paymentsCircle.startAnimation(scale_up_full_screen);
    }

    @Override
    public void onBackPressed() {
        Animation fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fade_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                recyclerView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation scale_down_full_screen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_down_full_screen);
                scale_down_full_screen.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        finish();
                        overridePendingTransition(0, 0);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                paymentsCircle.startAnimation(scale_down_full_screen);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        paymentsCircle.startAnimation(fade_in);
    }
}
