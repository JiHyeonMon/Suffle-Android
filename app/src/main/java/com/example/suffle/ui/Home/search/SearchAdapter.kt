package com.example.suffle.ui.Home.search

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.suffle.R

class SearchAdapter (private val context: Context): RecyclerView.Adapter<SearchViewHoler>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHoler {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SearchViewHoler, position: Int) {
        TODO("Not yet implemented")
    }

}

class SearchViewHoler(itemview: View): RecyclerView.ViewHolder(itemview){

    val txt_place = itemview.findViewById<TextView>(R.id.item_home_search_text)
    fun bind(){

    }
}