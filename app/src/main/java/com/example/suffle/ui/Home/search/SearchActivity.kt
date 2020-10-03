package com.example.suffle.ui.Home.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener
import com.example.suffle.R
import com.example.suffle.ui.Home.search.search1.FragmentAdapter
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_search_result_image.*
import kotlinx.android.synthetic.main.fragment_search_tab.*


class SearchActivity : AppCompatActivity() {


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        main_scroll_view.run {
            header = header_view
            stickListener = { _ ->
                Log.d("LOGGER_TAG", "stickListener")
                main_scroll_view.stopNestedScroll()
                frag_search_result_img_rv.isNestedScrollingEnabled = true


            }
            freeListener = { _ ->
                Log.d("LOGGER_TAG", "freeListener")
                frag_search_result_img_rv.isNestedScrollingEnabled = false
            }
        }

        header_view.adapter =
            FragmentAdapter(
                supportFragmentManager,
                2
            )
        header_view.currentItem = 0

        act_search_search.setOnClickListener {
            if (header_view.currentItem == 0) {
                header_view.currentItem = 1
            } else {
                header_view.currentItem = 0
            }

        }

    }
}