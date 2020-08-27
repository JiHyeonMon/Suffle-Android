package com.example.suffle.ui.Home.location

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.suffle.R
import com.example.suffle.data.SubwayData


class LocationAdapter(
    private val context: Context,
    private val clickListener: LocationViewHolder.onClickListener
) : RecyclerView.Adapter<LocationViewHolder>() {

    //    private lateinit var datas: Array<String>
    var datas = mutableListOf<SubwayData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_location_subway, parent, false)
        return LocationViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }

}

class LocationViewHolder(itemview: View, val clickListener: onClickListener) :
    RecyclerView.ViewHolder(itemview) {

    val txt_subway = itemview.findViewById<TextView>(R.id.item_location_subway)

    fun bind(subwayData: SubwayData) {
        txt_subway.text = subwayData.stationName
    }

    init {
        itemview.isSelected = false

        itemView.setOnClickListener {
            itemview.isSelected = !itemview.isSelected
            clickListener.onClickItem(adapterPosition)
        }
    }

    interface onClickListener {
        fun onClickItem(position: Int)
    }
}

