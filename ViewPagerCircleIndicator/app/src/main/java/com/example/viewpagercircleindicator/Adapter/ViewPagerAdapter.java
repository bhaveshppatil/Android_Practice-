package com.example.viewpagercircleindicator.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpagercircleindicator.Fragments.Fragment1;
import com.example.viewpagercircleindicator.Fragments.Fragment2;
import com.example.viewpagercircleindicator.Fragments.Fragment3;
import com.example.viewpagercircleindicator.Fragments.Fragment4;
import com.example.viewpagercircleindicator.Fragments.Fragment5;
import com.example.viewpagercircleindicator.Fragments.Fragment6;
import com.example.viewpagercircleindicator.Fragments.Fragment7;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            case 3:
                return new Fragment4();
            case 4:
                return new Fragment5();
            case 5:
                return new Fragment6();
            case 6:
                return new Fragment7();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
