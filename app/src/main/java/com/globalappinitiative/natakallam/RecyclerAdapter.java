package com.globalappinitiative.natakallam;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BundlesHolder> {

    private ArrayList<Bundles> bundleList;

    public RecyclerAdapter(ArrayList<Bundles> bundles) {
        this.bundleList = bundles;
    }

    @Override
    public RecyclerAdapter.BundlesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bundles, parent, false);
        return new BundlesHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.BundlesHolder holder, int position) {
        Bundles bundle = bundleList.get(position);
        holder.bindBundle(bundle);
    }

    @Override
    public int getItemCount() {
        return bundleList.size();
    }

    public static class BundlesHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView bundleTitle;
        private TextView bundleDescription;
        private Button bundlePurchase;

        public BundlesHolder(View v) {
            super(v);
            bundleTitle = (TextView) v.findViewById(R.id.textViewBundleTitle);
            bundleDescription = (TextView) v.findViewById(R.id.textViewBundleDescription);
            bundlePurchase = (Button) v.findViewById(R.id.buttonBundlePurchase);
            bundlePurchase.setOnClickListener(this);
        }

        public void bindBundle(Bundles bundle) {
            bundleTitle.setText(bundle.getTitle());
            bundleDescription.setText(bundle.getDescription());
        }

        @Override
        public void onClick(View v) {
            Log.d("Purchase", "CLICK");
        }
    }
}
