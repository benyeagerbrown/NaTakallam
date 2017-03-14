package com.globalappinitiative.natakallam;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.DialogFragment;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTimeFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    public AddTimeFragment() {
        // Required empty public constructor
    }


    @Override
    public TimePickerDialog onCreateDialog(Bundle savedInstanceState) {
        final java.util.Calendar c = java.util.Calendar.getInstance();

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));

    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }

}
