package com.globalappinitiative.natakallam;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

class RecyclerAdapterBundles extends RecyclerView.Adapter<RecyclerAdapterBundles.BundlesHolder> {

    private ArrayList<Bundles> bundleList;

    RecyclerAdapterBundles(ArrayList<Bundles> bundles) {
        this.bundleList = bundles;
    }

    @Override
    public RecyclerAdapterBundles.BundlesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bundles, parent, false);
        return new BundlesHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterBundles.BundlesHolder holder, int position) {
        Bundles bundle = bundleList.get(position);
        holder.bindBundle(bundle);
    }

    @Override
    public int getItemCount() {
        return bundleList.size();
    }

    static class BundlesHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {

        private TextView bundleTitle;
        private TextView bundleDescription;
        private TextView bundleCredits;

        BundlesHolder(View v) {
            super(v);
            bundleTitle = (TextView) v.findViewById(R.id.textViewBundleName);
            bundleDescription = (TextView) v.findViewById(R.id.textViewBundleDescription);
            bundleCredits = (TextView) v.findViewById(R.id.textViewBundleCredits);
            bundleCredits.setOnTouchListener(this);
        }

        void bindBundle(Bundles bundle) {
            bundleTitle.setText(bundle.getName());
            bundleDescription.setText(bundle.getDescription());
            bundleCredits.setText(Integer.toString(bundle.getCreditAmount()));
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    v.setBackgroundResource(R.drawable.solid_circle);
                    break;
                case MotionEvent.ACTION_UP:
                    v.setBackgroundResource(R.drawable.ring);
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                default:
                    v.setBackgroundResource(R.drawable.ring);
                    break;
            }
            return true;
        }
    }
}
