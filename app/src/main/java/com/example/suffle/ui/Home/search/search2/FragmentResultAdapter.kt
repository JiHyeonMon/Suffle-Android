package com.example.suffle.ui.Home.search.search2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.suffle.ui.Home.search.search2.resultImage.SearchResultImageFragment
import com.example.suffle.ui.Home.search.search2.resultMap.SearchResultMapFragment

class SearchResultAdapter(fm: FragmentManager, val fragmentCount: Int) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return SearchResultImageFragment()
            1 -> return SearchResultMapFragment()
            else -> null!!
        }
    }

    override fun getCount(): Int = fragmentCount

}