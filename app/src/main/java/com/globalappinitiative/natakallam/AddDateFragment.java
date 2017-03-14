package com.globalappinitiative.natakallam;


import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.DialogFragment;
import android.widget.DatePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{


    public AddDateFragment() {
        // Required empty public constructor
    }


    @Override
    public DatePickerDialog onCreateDialog(Bundle savedInstanceState) {

        final java.util.Calendar c = java.util.Calendar.getInstance();

        int year = c.get(java.util.Calendar.YEAR);
        int month = c.get(java.util.Calendar.MONTH);
        int day = c.get(java.util.Calendar.DAY_OF_MONTH);


        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

    }

}
