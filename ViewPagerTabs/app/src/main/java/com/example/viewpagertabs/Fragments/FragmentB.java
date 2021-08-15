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


public class FragmentB extends Fragment {
    private RecyclerView recyclerView;
    private List<String> dataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewB);
        buildPlacesData();
        setRecyclerView();
    }

    private void buildPlacesData() {
        dataList.add("Delhi City");
        dataList.add("Agra");
        dataList.add("Panjim");
        dataList.add("Varanasi");
        dataList.add("Shimla");
        dataList.add("Haridwar");
        dataList.add("Ooty");
        dataList.add("Jaipur");
        dataList.add("Tirupati");
        dataList.add("Andaman Islands");
        dataList.add("Shirdi");
        dataList.add("Manali");
        dataList.add("Ajanta Caves");

    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        DataAdapter dataAdapter = new DataAdapter(dataList);
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}