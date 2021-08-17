package com.example.recyclerview_we;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private ArrayList<Student> studentsList;

    public StudentAdapter(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentsList.get(position);
        holder.setData(student);

    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }
}
