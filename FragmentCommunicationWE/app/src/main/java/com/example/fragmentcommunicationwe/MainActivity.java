package com.example.fragmentcommunicationwe;

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
        toStudentDetails();
    }

    private void toStudentDetails() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        StudentDetailsFragment detailsFragment = new StudentDetailsFragment();
        detailsFragment.setListener(this);
        transaction.replace(R.id.frgContainer, detailsFragment, "details").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        StudPerformanceFragment detailsFragment = new StudPerformanceFragment();
        detailsFragment.setArguments(bundle);
        transaction.replace(R.id.frgContainer, detailsFragment, "detailsFragment").addToBackStack("addDetail").commit();
    }
}