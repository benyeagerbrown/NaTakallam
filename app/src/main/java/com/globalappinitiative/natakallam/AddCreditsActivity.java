package com.globalappinitiative.natakallam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddCreditsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapterBundles recyclerAdapterBundles;
    View paymentsCircle;
    ArrayList<Bundles> allBundles = new ArrayList<>();

    static final String bundles_url = "http://natakallam.eastus.cloudapp.azure.com/api/bundles/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_credits);

        paymentsCircle = findViewById(R.id.paymentsCircle);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getBundles();

        recyclerAdapterBundles = new RecyclerAdapterBundles(allBundles);
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

    private void getBundles() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, bundles_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("BundlesRequest", response.toString());
                try {
                    boolean isError = response.getBoolean("errors");
                    if (isError) {
                        getBundlesError();
                    } else {
                        JSONObject data = response.getJSONObject("data");
                        JSONArray bundlesArray = data.getJSONArray("bundles");
                        for (int i = 0; i < bundlesArray.length(); i++) {
                            JSONObject bundle = bundlesArray.getJSONObject(i);
                            String name = bundle.getString("name");
                            String description = bundle.getString("description");
                            int creditAmount = bundle.getInt("credit_amount");
                            int price = bundle.getInt("price");
                            int durationInDays = bundle.getInt("duration_in_days");
                            Bundles newBundle = new Bundles(name, description, creditAmount, price, durationInDays);
                            allBundles.add(newBundle);
                            recyclerAdapterBundles.notifyItemInserted(i);
                        }
                        setRecyclerView();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    getBundlesError();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("BundlesRequest", error.toString());
                error.printStackTrace();
                getBundlesError();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                String token = User.getValue(User.Keys.token, getApplicationContext());
                params.put("Authorization", "Bearer " + token);
                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    private void getBundlesError() {

    }

    private void setRecyclerView() {

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
