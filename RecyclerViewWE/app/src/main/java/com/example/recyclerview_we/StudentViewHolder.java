package com.example.recyclerview_we;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private TextView tvRollNo;
    private TextView age;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View view) {
        tvName = view.findViewById(R.id.tvName);
        tvRollNo = view.findViewById(R.id.tvRollNo);
        age = view.findViewById(R.id.tvAge);

    }
    public void setData(Student student){
        tvName.setText(student.getName());
        tvRollNo.setText(student.getRollNo());
        age.setText(student.getAge() + "");
    }
}
