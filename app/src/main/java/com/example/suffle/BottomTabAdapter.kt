package com.example.suffle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class BottomTabAdapter(fm: FragmentManager, val fragmentCount: Int) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment()
            1 -> return MapFragment()
            2 -> return FeedFragment()
            3 -> return MypageFragment()
            else -> null!!
        }
    }

    override fun getCount(): Int = fragmentCount

}