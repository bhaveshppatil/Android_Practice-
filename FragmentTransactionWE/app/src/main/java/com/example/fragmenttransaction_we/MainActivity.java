package com.example.fragmenttransaction_we;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    private Button btnAddA, btnAddB, btnRemoveA, btnRemoveB,
            replaceAToBWithout, replaceAToBWih, replaceBToAWithout, replaceBToAWith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnAddA = findViewById(R.id.addA);
        btnAddB = findViewById(R.id.addB);
        btnRemoveA = findViewById(R.id.removeA);
        btnRemoveB = findViewById(R.id.removeB);
        replaceBToAWith = findViewById(R.id.replaceBToAWith);
        replaceAToBWih = findViewById(R.id.replaceAToBWith);
        replaceAToBWithout = findViewById(R.id.replaceAToBWithout);
        replaceBToAWithout = findViewById(R.id.replaceBToAWithout);
        fragmentManager = getSupportFragmentManager();

        btnAddA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addA();
            }
        });

        btnAddB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addB();
            }
        });
        btnRemoveA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeA();
            }
        });
        btnRemoveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeB();
            }
        });
        replaceBToAWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceBWithA();
            }
        });

        replaceAToBWih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceAWithB();
            }
        });
        replaceAToBWithout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceAToBWithout();

            }
        });
        replaceBToAWithout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceBToAWithout();
            }
        });
    }

    private void replaceBToAWithout() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FirstFragment firstFragment = new FirstFragment();
        transaction.replace(R.id.frContainer, firstFragment, "firstFragment").commit();
    }
    private void replaceAToBWithout() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        SecondFragment secondFragment = new SecondFragment();
        transaction.replace(R.id.frContainer, secondFragment, "secondFragment").commit();
    }

    private void replaceBWithA(){
        FragmentTransaction t = fragmentManager.beginTransaction();
        FirstFragment firstFragment = new FirstFragment();
        t.replace(R.id.frContainer, firstFragment, "firstFragment").addToBackStack("FirstFr").commit();

    }

    private void replaceAWithB(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SecondFragment secondFragment = new SecondFragment();
        fragmentTransaction.replace(R.id.frContainer, secondFragment, "secondFragment").addToBackStack("SecondFr").commit();
    }

    private void removeB() {
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("secondFragment");
        if (secondFragment != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(secondFragment).commit();

        }
    }

    private void removeA() {
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("firstFragment");
        if (firstFragment != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(firstFragment).commit();
        }
    }

    private void addB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SecondFragment secondFragment = new SecondFragment();
        fragmentTransaction.add(R.id.frContainer, secondFragment,"secondFragment").addToBackStack("addSecond").commit();
    }

    private void addA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment firstFragment = new FirstFragment();
        fragmentTransaction.add(R.id.frContainer, firstFragment,"firstFragment").addToBackStack("addFirst").commit();
    }
}