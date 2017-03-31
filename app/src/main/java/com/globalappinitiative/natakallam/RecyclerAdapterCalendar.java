package com.globalappinitiative.natakallam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class RecyclerAdapterCalendar extends RecyclerView.Adapter<RecyclerAdapterCalendar.AppointmentHolder> {

    private ArrayList<Appointment> appointmentsList;

    RecyclerAdapterCalendar(ArrayList<Appointment> appointments) {
        this.appointmentsList = appointments;
    }

    @Override
    public RecyclerAdapterCalendar.AppointmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment, parent, false);
        return new AppointmentHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterCalendar.AppointmentHolder holder, int position) {
        Appointment appointment = appointmentsList.get(position);
        holder.bindAppointment(appointment);
    }

    @Override
    public int getItemCount() {
        return appointmentsList.size();
    }

    static class AppointmentHolder extends RecyclerView.ViewHolder {

        private TextView textViewCalendarDay;
        private TextView textViewCalendarTime;
        private TextView textViewCalendarTutor;

        AppointmentHolder(View v) {
            super(v);
            textViewCalendarDay = (TextView) v.findViewById(R.id.textViewCalendarDay);
            textViewCalendarTime = (TextView) v.findViewById(R.id.textViewCalendarTime);
            textViewCalendarTutor = (TextView) v.findViewById(R.id.textViewCalendarTutor);
        }

        void bindAppointment(Appointment appointment) {
            textViewCalendarDay.setText(appointment.getDay());
            textViewCalendarTime.setText(appointment.getTime());
            textViewCalendarTutor.setText(appointment.getTutor());
        }
    }
}
