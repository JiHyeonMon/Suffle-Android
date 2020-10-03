package com.example.suffle.ui.Home.search.search1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suffle.R
import com.example.suffle.ui.Home.search.search1.SearchRecommandAdapter
import com.example.suffle.ui.Home.search.search1.SearchRecommandViewHoler
import kotlinx.android.synthetic.main.fragment_search_recommand.*

class SearchRecommandFragment : Fragment() {

    lateinit var searchRecommandAdapter: SearchRecommandAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_recommand, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        searchRecommandAdapter =
            SearchRecommandAdapter(view.context,
                object :
                    SearchRecommandViewHoler.onClickItem {
                    override fun onClick(position: Int) {
                        Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                    }

                })

        frag_search_recommand_rv.adapter = searchRecommandAdapter
        frag_search_recommand_rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        searchRecommandAdapter.notifyDataSetChanged()

    }
}