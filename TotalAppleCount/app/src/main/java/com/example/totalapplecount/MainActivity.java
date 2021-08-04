package com.example.totalapplecount;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements Listener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        toTotalAppleFrg();
    }

    private void toTotalAppleFrg() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TotalApplesFragment applesFragment = new TotalApplesFragment();
        transaction.add(R.id.frgContainer, applesFragment, "totalApples").addToBackStack("totalApples").commit();
    }

    @Override
    public void launchTotalAppleFragment(Bundle bundle) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        totalApplesFragment.setArguments(bundle);
        transaction.replace(R.id.frgContainer, totalApplesFragment, "ApplesFragment").addToBackStack("ApplesFragment").commit();
    }

    @Override
    public void launchBuyAppleFragment(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BuyApplesFragment buyApplesFragment = new BuyApplesFragment();
        buyApplesFragment.setArguments(bundle);
        transaction.replace(R.id.frgContainer, buyApplesFragment, "buyApples").addToBackStack("buyAdd").commit();
    }
}