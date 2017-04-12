package com.globalappinitiative.natakallam;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class PaymentsFragment extends Fragment implements View.OnClickListener {

    View PaymentsFragmentView;
    View paymentsCircle;
    TextView textViewCredits;
    Button buttonAddCredits;

    public PaymentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PaymentsFragmentView = inflater.inflate(R.layout.fragment_payments, container, false);
        textViewCredits = (TextView) PaymentsFragmentView.findViewById(R.id.textViewCredits);
        buttonAddCredits = (Button) PaymentsFragmentView.findViewById(R.id.buttonAddCredits);
        buttonAddCredits.setOnClickListener(this);
        paymentsCircle = PaymentsFragmentView.findViewById(R.id.paymentsCircle);
        Animation scale_up = AnimationUtils.loadAnimation(getContext(), R.anim.scale_up);
        scale_up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                textViewCredits.setVisibility(View.INVISIBLE);
                buttonAddCredits.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textViewCredits.setVisibility(View.VISIBLE);
                buttonAddCredits.setVisibility(View.VISIBLE);
                Animation fade_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
                textViewCredits.startAnimation(fade_in);
                buttonAddCredits.startAnimation(fade_in);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        paymentsCircle.startAnimation(scale_up);
        return PaymentsFragmentView;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(), AddCreditsActivity.class));
        getActivity().overridePendingTransition(0, 0);
    }
}
