package com.example.viewpagertabs.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagertabs.DataAdapter;
import com.example.viewpagertabs.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentA extends Fragment {
    private RecyclerView recyclerView;
    private List<String> dataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewA);
        buildNamesData();
        setRecyclerView();
    }

    private void buildNamesData() {


        dataList.add("Jeff Bezos");
        dataList.add("Elon Musk");
        dataList.add("Warren Buffett");
        dataList.add("Mark Zuckerberg");
        dataList.add("Larry Page");
        dataList.add("Larry Ellison");
        dataList.add("Mukesh Ambani");
        dataList.add("Sergey Brin");
        dataList.add("Amancio Ortega");
        dataList.add("Alice Walton");
        dataList.add("David Koch");

    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        DataAdapter dataAdapter = new DataAdapter(dataList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);
    }
}