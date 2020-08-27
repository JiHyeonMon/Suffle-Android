package com.example.suffle.ui.Home.search.search2

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.suffle.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_search_tab.*

class SearchTabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTab()
        setAdapter()

    }
    private fun setTab(){
        val topTabBar: View = LayoutInflater.from(context).inflate(R.layout.tab_home_search_result, null)
        frag_search_tab_tab.run {
            addTab(
                this.newTab()
                    .setCustomView(topTabBar.findViewById(R.id.tab_home_search_cl1) as ConstraintLayout)
            )
            addTab(
                this.newTab()
                    .setCustomView(topTabBar.findViewById(R.id.tab_home_search_cl2) as ConstraintLayout)
            )
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setAdapter(){
        frag_search_tab_viewpager.adapter =
            SearchResultAdapter(
                childFragmentManager,
                2
            )

        frag_search_tab_viewpager.currentItem = 0

        frag_search_tab_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(frag_search_tab_tab))

        frag_search_tab_tab!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                frag_search_tab_viewpager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })


    }
}