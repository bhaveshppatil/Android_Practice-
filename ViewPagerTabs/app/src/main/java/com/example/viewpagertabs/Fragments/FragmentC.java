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


public class FragmentC extends Fragment {
    private RecyclerView recyclerView;
    private List<String> dataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewC);
        buildTourismData();
        setRecyclerView();
    }

    public void buildTourismData() {
        dataList.add("Manali");
        dataList.add("Leh Ladakh");
        dataList.add("Coorg ");
        dataList.add("Andaman ");
        dataList.add("Goa");
        dataList.add("Udaipur");
        dataList.add("Alibaug");
        dataList.add("Panchgani");
        dataList.add("Mahabaleshwar");
        dataList.add("munnar");
        dataList.add("coalkers walk");
        dataList.add("love lake");
        dataList.add("abhey falls");

    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        DataAdapter dataAdapter = new DataAdapter(dataList);
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}