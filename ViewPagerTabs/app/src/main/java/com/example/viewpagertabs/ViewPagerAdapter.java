package com.example.viewpagertabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpagertabs.Fragments.FragmentA;
import com.example.viewpagertabs.Fragments.FragmentB;
import com.example.viewpagertabs.Fragments.FragmentC;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentA();
            case 1:
                return new FragmentB();
            case 2:
                return new FragmentC();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
