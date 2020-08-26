package com.example.suffle.ui.Home.location

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.suffle.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_location.*


class LocationActivity : AppCompatActivity() {

    //    val subwayData = mutableListOf<SubwayData>()

    // 리스트를 생성한다.
    val list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        act_search_btn_back.setOnClickListener {
            finish()
        }


        setAdapter()
        act_location_tab.setupWithViewPager(act_location_viewpager)




        settingList()

        act_location_auto_text.setAdapter(
            ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line, list
            )
        )
    }

    private fun settingList() {
        list.add("apple")
        list.add("ant")
        list.add("aunt")
        list.add("alice")
        list.add("a")
        list.add("크리aa스탈")
        list.add("aaa")
        list.add("손dd나은")
        list.add("남ssaa주혁")
    }

    private fun setAdapter(){

        val pagerAdapter = SubwayAdapter(supportFragmentManager, 11)
        act_location_viewpager.adapter = pagerAdapter

        act_location_viewpager.offscreenPageLimit = 10
        act_location_viewpager.currentItem = 0


        act_location_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(act_location_tab))

        act_location_tab!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                act_location_viewpager.currentItem = tab.position

                val arguments = Bundle().apply {
                    putString("KEY", "value")
                }

                if (act_location_tab.selectedTabPosition == 0) {
//                    locationAdapter.datas = subwayData
//                    locationAdapter.notifyDataSetChanged()
                } else if (act_location_tab.selectedTabPosition == 1) {
//                    locationAdapter.datas = subwayData2
//                    locationAdapter.notifyDataSetChanged()
                } else if (act_location_tab.selectedTabPosition == 2) {
//                    locationAdapter.datas = subwayData1
//                    locationAdapter.notifyDataSetChanged()
                } else if (act_location_tab.selectedTabPosition == 3) {
//                    locationAdapter.datas = subwayData2
//                    locationAdapter.notifyDataSetChanged()
                } else if (act_location_tab.selectedTabPosition == 4) {
//                    locationAdapter.datas = subwayData4
//                    locationAdapter.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

    }


    private inner class SubwayAdapter(fm: FragmentManager, val fragmentCount: Int) :
        FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return SubwayFragment.newInstance("my")
                1 -> return SubwayFragment.newInstance("hot")
                2 -> return SubwayFragment.newInstance("1")
                3 -> return SubwayFragment.newInstance("2")
                4 -> return SubwayFragment.newInstance("4")
                5 -> return SubwayFragment.newInstance("1")
                6 -> return SubwayFragment.newInstance("2")
                7 -> return SubwayFragment.newInstance("1")
                8 -> return SubwayFragment.newInstance("my")
                9 -> return SubwayFragment.newInstance("my")
                10 -> return SubwayFragment.newInstance("my")
                11 -> return SubwayFragment.newInstance("2")
                else -> null!!
            }
        }

        override fun getCount(): Int = fragmentCount

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "내 주변"
                1 -> return "HOT"
                2 -> return "1호선"
                3 -> return "2호선"
                4 -> return "3호선"
                5 -> return "4호선"
                6 -> return "5호선"
                7 -> return "6호선"
                8 -> return "7호선"
                9 -> return "8호선"
                10 -> return "9호선"

            }
            return null
        }

    }
}