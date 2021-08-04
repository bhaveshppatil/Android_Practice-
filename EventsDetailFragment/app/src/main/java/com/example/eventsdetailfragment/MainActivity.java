package com.example.eventsdetailfragment;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.eventsdetailfragment.Fragments.EventDetailsFragment;
import com.example.eventsdetailfragment.Fragments.PriceDetailsFragment;
import com.example.eventsdetailfragment.Fragments.TimeAndDateFragment;

public class MainActivity extends AppCompatActivity implements FragmentCommunication {

    private FragmentManager fragmentManager;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.FragContainer);
        toFirstFrag();
    }

    private void toFirstFrag() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        EventDetailsFragment detailsFragment = new EventDetailsFragment();
        transaction.add(R.id.FragContainer, detailsFragment, "detailsFragment").commit();
    }

    @Override
    public void launchSecondFrag(Bundle bundle) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TimeAndDateFragment dateFragment = new TimeAndDateFragment();
        dateFragment.setArguments(bundle);
        transaction.add(R.id.FragContainer, dateFragment, "date").addToBackStack("dateFrag").commit();
    }


    @Override
    public void launchThirdFrag(Bundle bundle) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
        priceDetailsFragment.setArguments(bundle);
        transaction.add(R.id.FragContainer, priceDetailsFragment, "price").addToBackStack("priceFrag").commit();
    }

}