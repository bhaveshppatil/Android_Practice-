package com.example.moneymanager

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.moneymanager.Adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MoneyManager : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_manager)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Income"))
        tabLayout.addTab(tabLayout.newTab().setText("Expense"))
        (tabLayout).setTabTextColors(
            ContextCompat.getColor(this, R.color.white),
            ContextCompat.getColor(this, R.color.black)
        )

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = ViewPagerAdapter(this, supportFragmentManager, tabLayout.tabCount)

        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                tabLayout.getTabAt(0)?.icon?.setColorFilter(
                    resources.getColor(android.R.color.black),
                    PorterDuff.Mode.SRC_IN
                );
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tabLayout.getTabAt(2)?.icon
                    ?.setColorFilter(
                        resources.getColor(android.R.color.white),
                        PorterDuff.Mode.SRC_IN
                    );
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }
}