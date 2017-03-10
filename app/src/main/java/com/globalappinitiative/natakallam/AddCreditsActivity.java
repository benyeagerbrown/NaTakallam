package com.globalappinitiative.natakallam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(bundleList);
        recyclerView.setAdapter(recyclerAdapter);

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
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
