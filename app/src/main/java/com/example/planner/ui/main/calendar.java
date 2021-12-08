package com.example.planner.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.planner.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calendar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calendar extends Fragment {


    public calendar() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calendar, container, false);
            TextView study_number = v.findViewById(R.id.study_number);
            TextView assign_number = v.findViewById(R.id.assign_number);
            TextView exams_number = v.findViewById(R.id.exams_number);
            TextView lecture_number = v.findViewById(R.id.lectures_number);
            TextView date_text = v.findViewById(R.id.date_text);
            CalendarView calendarView = v.findViewById(R.id.calendar);
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    String day = dayOfMonth >= 10 ? String.valueOf(dayOfMonth) : "0" + dayOfMonth;
                    String mon = (month + 1) >= 10 ? String.valueOf(month + 1) : "0" + (month + 1);
                    String date = day + "-" + mon + "-" + year;

                    date_text.setText(date);
                }
            });


        return v;
    }
}