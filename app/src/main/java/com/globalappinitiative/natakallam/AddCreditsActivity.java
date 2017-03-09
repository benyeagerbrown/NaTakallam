package com.globalappinitiative.natakallam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class AddCreditsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_credits);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Bundles> bundleList = new ArrayList<>();
        for(int i=0; i<30; i++) {
            bundleList.add(new Bundles("Bundle " + Integer.toString(i), "Description"));
        }

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(bundleList);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
