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


public class BuyApplesFragment extends Fragment {

    private EditText etBuyAmount;
    private Button btnBuy;
    private TextView tvTotalApple;
    private int availableApples;
    private Listener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            availableApples = getArguments().getInt("totalApple");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_apples, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (Listener) context;
    }

    private void initViews(View view) {
        etBuyAmount = view.findViewById(R.id.etBuyAmount);
        btnBuy = view.findViewById(R.id.btnBuy);
        tvTotalApple = view.findViewById(R.id.tvTotalApple);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                int buyAmount = Integer.parseInt(etBuyAmount.getText().toString());

                if (buyAmount > availableApples) {
                    etBuyAmount.setError(buyAmount + " apple's are not available");
                } else {
                    int balanceApple = availableApples - buyAmount;
                    bundle.putInt("balanceApple", balanceApple);
                    tvTotalApple.setText("Apple's left " + balanceApple);
                    listener.launchTotalAppleFragment(bundle);
                }
            }
        });
    }
}