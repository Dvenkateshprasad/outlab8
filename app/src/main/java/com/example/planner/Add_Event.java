package com.example.planner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.planner.R;
import com.example.planner.tab;
import com.example.planner.ui.main.PlaceholderFragment;

public class Add_Event extends Fragment {

    public Add_Event(){

    }

    String[] Event_Type={"Study Plans", "Assignments", "Exams", "Lectures"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_event, container, false);

        //Spinner spin = (Spinner) view.findViewById(R.id.spinner);
        //spin.setOnItemSelectedListener(getContext());

        //Creating the ArrayAdapter instance having the country list
        //ArrayAdapter aa = new ArrayAdapter(getContext(),
        //        android.R.layout.simple_spinner_item,
        //        Event_Type);
        //aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        //spin.setAdapter(aa);

        Button btn_add_event = (Button) view.findViewById(R.id.button);
        btn_add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getChildFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new PlaceholderFragment());
                fr.commit();
            }
        });
        return view;
    }
}