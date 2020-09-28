package com.example.suffle.ui.Map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.MarkerData
import com.example.suffle.data.MapPersonData
import kotlinx.android.synthetic.main.item_frag_map_circle.view.*


class MapPersonAdapter (private val context: Context, private val clickListener: MapPersonViewHolder.onClickListener): RecyclerView.Adapter<MapPersonViewHolder>(){

    var datas = mutableListOf<MapPersonData>()
    var markerData = mutableListOf<MarkerData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapPersonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag_map_circle, parent, false)
        return MapPersonViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holderMap: MapPersonViewHolder, position: Int) {
        holderMap.bind(datas[position])
        previousPosition = position
    }

}

class MapPersonViewHolder(itemview: View, private val clickListener: onClickListener) : RecyclerView.ViewHolder(itemview){
    val img_person= itemview.findViewById<ImageView>(R.id.item_frag_map_circle_img)
    val txt_personName = itemView.findViewById<TextView>(R.id.item_frag_circle_txt)

    fun bind(mapPersonData: MapPersonData) {
        txt_personName.text = mapPersonData.txt_personName
        Glide.with(itemView).load(mapPersonData.img_person).circleCrop().into(img_person)

    }

    init {

        itemView.setOnClickListener {
            clickListener.onClickItem(adapterPosition)
            itemview.item_frag_map_circle_img.isSelected = !itemview.item_frag_map_circle_img.isSelected

        }

    }

    interface onClickListener {
        fun onClickItem(position: Int)
    }
}