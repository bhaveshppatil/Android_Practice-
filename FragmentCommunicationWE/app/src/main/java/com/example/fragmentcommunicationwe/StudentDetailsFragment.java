package com.example.fragmentcommunicationwe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentDetailsFragment extends Fragment {

    private EditText etName, etAge;
    private Button btnNext;
    private Listener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_details, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    private void initViews(View view) {
        etName = view.findViewById(R.id.etName);
        etAge = view.findViewById(R.id.etAge);
        btnNext = view.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putInt("age", age);
                if (listener != null){
                    listener.launchPerformanceFragment(bundle);
                }
            }
        });
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }
}