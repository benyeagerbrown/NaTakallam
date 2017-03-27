package com.globalappinitiative.natakallam;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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

    static class TabooTopicsHolder extends RecyclerView.ViewHolder {

        private TextView textViewTabooTopicTitle;
        private TextView textViewTabooTopicDescription;

        TabooTopicsHolder(View v) {
            super(v);
            textViewTabooTopicTitle = (TextView) v.findViewById(R.id.textViewTabooTopicTitle);
            textViewTabooTopicDescription = (TextView) v.findViewById(R.id.textViewTabooTopicDescription);
        }

        void bindTabooTopic(TabooTopic tabooTopic) {
            textViewTabooTopicTitle.setText(tabooTopic.getTopic());
            textViewTabooTopicDescription.setText(tabooTopic.getDescription());
        }
    }
}
