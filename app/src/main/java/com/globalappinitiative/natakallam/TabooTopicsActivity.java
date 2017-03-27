package com.globalappinitiative.natakallam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TabooTopicsActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private Button buttonAddTabooTopic;
    private RecyclerAdapterTaboo recyclerAdapterTaboo;

    private ArrayList<TabooTopic> tabooTopicsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taboo_topics);

        buttonAddTabooTopic = (Button) findViewById(R.id.buttonAddTabooTopic);
        buttonAddTabooTopic.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        tabooTopicsList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            tabooTopicsList.add(new TabooTopic("Topic " + Integer.toString(i), "Description"));
        }

        recyclerAdapterTaboo = new RecyclerAdapterTaboo(tabooTopicsList);
        recyclerView.setAdapter(recyclerAdapterTaboo);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == buttonAddTabooTopic.getId()) {
            tabooTopicsList.add(new TabooTopic("extra", "Description"));
            recyclerAdapterTaboo.notifyItemInserted(tabooTopicsList.size() - 1);
        }
    }
}
