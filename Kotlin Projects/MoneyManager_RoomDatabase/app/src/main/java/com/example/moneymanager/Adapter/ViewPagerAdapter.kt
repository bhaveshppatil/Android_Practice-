package com.example.moneymanager.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.moneymanager.Fragments.ExpenseFragment
import com.example.moneymanager.Fragments.IncomeFragment

internal class ViewPagerAdapter(
    context: Context,
    fragmentManager: FragmentManager,
    var totalTabs: Int
) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                IncomeFragment()
            }
            1 -> {
                ExpenseFragment()
            }
            else -> getItem(position)
        }
    }
}