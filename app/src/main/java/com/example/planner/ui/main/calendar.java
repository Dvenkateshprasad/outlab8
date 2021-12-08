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

import java.util.Calendar;


public class calendar extends Fragment {


    public calendar() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public String modify(int day,int month, int year){
        String daym = day >= 10 ? String.valueOf(day) : "0" + day;
        String mon = (month + 1) >= 10 ? String.valueOf(month + 1) : "0" + (month + 1);
        String date = daym + "-" + mon + "-" + year;
        return date;
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
            Calendar c = Calendar.getInstance();
            String s = modify(c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.MONTH),c.get(Calendar.YEAR));
            date_text.setText(s);
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    String date = modify(dayOfMonth,month,year);
                    date_text.setText(date);

                }
            });


        return v;
    }
}