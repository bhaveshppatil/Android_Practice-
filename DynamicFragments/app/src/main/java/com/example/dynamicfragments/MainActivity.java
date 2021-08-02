package com.example.dynamicfragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd;
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        fragmentManager = getSupportFragmentManager();
        frameLayout = findViewById(R.id.frContainer);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFrg();
                btnAdd.setVisibility(View.GONE);
            }
        });
    }

    private void replaceFrg() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        DynamicFragment dynamicFragment = new DynamicFragment();
        transaction.replace(R.id.frContainer, dynamicFragment, "dynamicFragment").addToBackStack("dynamicFrg").commit();
    }
}