package com.example.suffle.ui.Home.search.search1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.suffle.R


class SearchRecommandAdapter(
    private val context: Context,
    private val clickItem: SearchRecommandViewHoler.onClickItem
) : RecyclerView.Adapter<SearchRecommandViewHoler>() {

    val datas = arrayListOf("공릉 철길", "백종원 맛집", "골목식당 맛집", "공트럴 파크", "라라브레드")
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecommandViewHoler {
        val view = LayoutInflater.from(context).inflate(R.layout.item_home_search, parent, false)
        return SearchRecommandViewHoler(
            view,
            clickItem
        )
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: SearchRecommandViewHoler, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }

}

class SearchRecommandViewHoler(itemview: View, val clickItem: onClickItem) :
    RecyclerView.ViewHolder(itemview) {

    val txt_place = itemview.findViewById<TextView>(R.id.item_home_search_text)

    fun bind(data: String) {
        txt_place.text = data
    }

    init {
        itemview.setOnClickListener {
            clickItem.onClick(adapterPosition)
        }
    }

    interface onClickItem {
        fun onClick(position: Int)
    }
}