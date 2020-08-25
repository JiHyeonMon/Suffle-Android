package com.example.suffle.ui.Home.location

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.suffle.R
import com.example.suffle.data.SubwayData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.activity_location.*


class LocationActivity : AppCompatActivity() {

    //    val subwayData = mutableListOf<SubwayData>()
    lateinit var locationAdapter: LocationAdapter

    val subwayData = arrayListOf(
        SubwayData("6", "태릉입구"),
        SubwayData("6", "태릉입구"),
        SubwayData("6", "태릉입구")
    )

    val subwayData1 = arrayListOf(
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계"),
        SubwayData("1", "석계")
    )

    val subwayData2 = arrayListOf(
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구"),
        SubwayData("2", "홍대입구")
    )

    val subwayData4 = arrayListOf(
        SubwayData("4", "서울역")
    )

    // 리스트를 생성한다.
    val list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        act_location_btn_back.setOnClickListener {
            finish()
        }

        act_location_tab.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (act_location_tab.getSelectedTabPosition() === 0) {
                    locationAdapter.datas = subwayData
                    locationAdapter.notifyDataSetChanged()
                } else if (act_location_tab.getSelectedTabPosition() === 1) {
                    locationAdapter.datas = subwayData2
                    locationAdapter.notifyDataSetChanged()
                } else if (act_location_tab.getSelectedTabPosition() === 2) {
                    locationAdapter.datas = subwayData1
                    locationAdapter.notifyDataSetChanged()
                } else if (act_location_tab.getSelectedTabPosition() === 3) {
                    locationAdapter.datas = subwayData2
                    locationAdapter.notifyDataSetChanged()
                } else if (act_location_tab.getSelectedTabPosition() === 4) {
                    locationAdapter.datas = subwayData4
                    locationAdapter.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        locationAdapter = LocationAdapter(this,
            object : LocationViewHolder.onClickListener {
                override fun onClickItem(position: Int) {

                }
            })

        act_location_rv.adapter = locationAdapter
        act_location_rv.layoutManager = GridLayoutManager(this, 4)

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
}