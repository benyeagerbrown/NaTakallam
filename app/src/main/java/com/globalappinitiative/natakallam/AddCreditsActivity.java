package com.globalappinitiative.natakallam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

public class AddCreditsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapterBundles recyclerAdapterBundles;
    View paymentsCircle;
    List<com.globalappinitiative.natakallam.Bundle> allBundles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_credits);

        allBundles = UserDataInstance.get().getData().getBundles();
        setRecyclerView();
        startEntryAnimation();
    }

    private void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapterBundles = new RecyclerAdapterBundles(allBundles);
        recyclerView.setAdapter(recyclerAdapterBundles);
    }

    private void startEntryAnimation() {
        paymentsCircle = findViewById(R.id.paymentsCircle);
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
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
