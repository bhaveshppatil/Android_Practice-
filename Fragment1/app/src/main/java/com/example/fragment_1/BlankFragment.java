package com.example.fragment_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<AnimalModel> animalModelList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void buildList() {
        animalModelList.add(new AnimalModel("Black Panther", R.drawable.black_panther_in_india));
        animalModelList.add(new AnimalModel("African Leopard", R.drawable.african_leopard_male));
        animalModelList.add(new AnimalModel("Caracal cat", R.drawable.caracal_cat));
        animalModelList.add(new AnimalModel("Clouded Leopard", R.drawable.clouded_leopard));
        animalModelList.add(new AnimalModel("Elephant", R.drawable.elephant));
        animalModelList.add(new AnimalModel("Black Panther", R.drawable.black_panther_in_india));
        animalModelList.add(new AnimalModel("African Leopard", R.drawable.african_leopard_male));
        animalModelList.add(new AnimalModel("Caracal cat", R.drawable.caracal_cat));
        animalModelList.add(new AnimalModel("Clouded Leopard", R.drawable.clouded_leopard));
        animalModelList.add(new AnimalModel("Elephant", R.drawable.elephant));
        animalModelList.add(new AnimalModel("Black Panther", R.drawable.black_panther_in_india));
        animalModelList.add(new AnimalModel("African Leopard", R.drawable.african_leopard_male));
        animalModelList.add(new AnimalModel("Caracal cat", R.drawable.caracal_cat));
        animalModelList.add(new AnimalModel("Clouded Leopard", R.drawable.clouded_leopard));
        animalModelList.add(new AnimalModel("Elephant", R.drawable.elephant));

    }
    private void setRecyclerView(){
        AnimalAdapter animalAdapter = new AnimalAdapter(animalModelList);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(animalAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        buildList();
        setRecyclerView();
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }
}