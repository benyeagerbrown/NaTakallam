package com.globalappinitiative.natakallam;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

class RecyclerAdapterTaboo extends RecyclerView.Adapter<RecyclerAdapterTaboo.TabooTopicsHolder> {

    private ArrayList<TabooTopic> tabooTopicsList;

    RecyclerAdapterTaboo(ArrayList<TabooTopic> tabooTopicsList) {
        this.tabooTopicsList = tabooTopicsList;
    }

    @Override
    public RecyclerAdapterTaboo.TabooTopicsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.taboo_topic, parent, false);
        return new TabooTopicsHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterTaboo.TabooTopicsHolder holder, int position) {
        TabooTopic tabooTopic = tabooTopicsList.get(position);
        holder.bindTabooTopic(tabooTopic);
    }

    @Override
    public int getItemCount() {
        return tabooTopicsList.size();
    }

    static class TabooTopicsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private EditText editTextTabooTopicTitle;
        private EditText editTextTabooTopicDescription;

        TabooTopicsHolder(View v) {
            super(v);
            editTextTabooTopicTitle = (EditText) v.findViewById(R.id.editTextTabooTopicTitle);
            editTextTabooTopicDescription = (EditText) v.findViewById(R.id.editTextTabooTopicDescription);
        }

        void bindTabooTopic(TabooTopic tabooTopic) {
            editTextTabooTopicTitle.setText(tabooTopic.getTopic());
            editTextTabooTopicDescription.setText(tabooTopic.getDescription());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
