package com.example.planner.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planner.Adapter;
import com.example.planner.Add_Event;
import com.example.planner.Add_event_2;
import com.example.planner.DatabaseHelper;
import com.example.planner.MainActivity;
import com.example.planner.R;
import com.example.planner.design;
import com.example.planner.tab;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<design> userList;
    Adapter adapter;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
            int index = 1;
            if (getArguments() != null) {
                index = getArguments().getInt(ARG_SECTION_NUMBER);
            }

        pageViewModel.setIndex(index);


    }

    private void initRecycerView(View v) {
        recyclerView = v.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        FloatingActionButton fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Add_event_2.class);
                startActivity(intent);
            }
        });
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void OnDeleteClick(int position) {
                removeItem(position);
            }
        });

    }
    private void initData(View v){
        userList = new ArrayList<>();
        userList.add(new design("lol","f","lmfao","hello"));
        userList.add(new design("lol","f","lmfao","hello"));
        userList.add(new design("lol","f","lmfao","hello"));
        userList.add(new design("lol","f","lmfao","hello"));
        userList.add(new design("lol","f","lmfao","hello"));
        userList.add(new design("lol","f","lmfao","hello"));
        userList.add(new design("lol","f","lmfao","hello"));
        userList.add(new design("lol","f","lmfao","hello"));
        userList.add(new design("lol","f","lmfao","hello"));

    }

    public void removeItem(int position){
        userList.remove(position);
        adapter.notifyItemRemoved(position);
    }
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        initData(root);
        initRecycerView(root);

        return root;
    }
}