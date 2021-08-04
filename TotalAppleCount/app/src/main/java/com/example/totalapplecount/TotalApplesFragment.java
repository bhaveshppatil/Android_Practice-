package com.example.totalapplecount;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class TotalApplesFragment extends Fragment {

    private EditText etTotalApple;
    private Button btnNext;
    private int balance;
    private TextView tvBalanceApple;
    private Listener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        if (getArguments() != null) {
            balance = getArguments().getInt("balanceApple");
            tvBalanceApple.setText("Available Apple's " + balance);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (Listener) context;
    }

    private void initViews(View view) {

        etTotalApple = view.findViewById(R.id.etTotalApple);
        btnNext = view.findViewById(R.id.btnNext);
        tvBalanceApple = view.findViewById(R.id.tvBalanceApple);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalApple = Integer.parseInt(etTotalApple.getText().toString());
                tvBalanceApple.setText("Total Available Apple's" + totalApple);
                Bundle bundle = new Bundle();
                bundle.putInt("totalApple", totalApple);
                listener.launchBuyAppleFragment(bundle);
            }
        });
    }
}