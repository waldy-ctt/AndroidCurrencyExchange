package com.waldy.androidcurrencyexchange

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    private val tabContentText = listOf<String>(
        "This is content of tab 1",
        "This is content of tab 2"
    )

    override fun getItemCount(): Int {
        return tabContentText.size
    }

    override fun createFragment(position: Int): Fragment {
        val contentText = tabContentText[position]
        return TabContentFragment.newInstance(contentText)
    }

    fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> "TEST1"
            1 -> "TEST2"
            else -> "TAB"
        }
    }
}