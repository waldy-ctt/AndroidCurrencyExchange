package com.waldy.androidcurrencyexchange

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
       return 2;
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CurrencyExchangeFragment()
            1 -> RatioFragment()
            else -> throw IllegalStateException("Invalid Position")
        }
    }
}