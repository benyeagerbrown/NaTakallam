package com.globalappinitiative.natakallam;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CalendarFragment extends Fragment {

    private View CalendarFragmentView;
    private RecyclerAdapterCalendar recyclerAdapterCalendar;
    private ArrayList<Appointment> appointmentsList;


    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CalendarFragmentView = inflater.inflate(R.layout.fragment_calendar, container, false);
        RecyclerView recyclerView = (RecyclerView) CalendarFragmentView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        appointmentsList = new ArrayList<>();
        appointmentsList.add(new Appointment("March 31, 2017", "4:00PM EST", "Tutor: Brett"));
        appointmentsList.add(new Appointment("April 10, 2017", "12:00PM EST", "Tutor: Ben"));

        recyclerAdapterCalendar = new RecyclerAdapterCalendar(appointmentsList);
        recyclerView.setAdapter(recyclerAdapterCalendar);
        return CalendarFragmentView;
    }

}
