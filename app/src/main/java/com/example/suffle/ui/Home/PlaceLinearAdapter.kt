package com.example.suffle.ui.Home

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.suffle.R
import com.example.suffle.data.PlaceData
import kotlinx.android.synthetic.main.item_frag_home_linear_list.view.*
import kotlin.math.roundToInt

class PlaceLinearAdapter (private val context: Context, private val clickListener: PlaceLinearViewHolder.onClickListener, private val clickBookmark: PlaceLinearViewHolder.onClickBookmark): RecyclerView.Adapter<PlaceLinearViewHolder>(){

    var datas = mutableListOf<PlaceData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceLinearViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag_home_linear_list, parent, false)
        return PlaceLinearViewHolder(view, clickListener, clickBookmark)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: PlaceLinearViewHolder, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }

}

class PlaceLinearViewHolder(itemview: View, val clickListener: onClickListener, val clickBookmark: onClickBookmark) : RecyclerView.ViewHolder(itemview){
    val img_place = itemview.findViewById<ImageView>(R.id.img_place)
    val bookmark = itemview.findViewById<ImageView>(R.id.img_bookmark)
    val txt_placeName = itemView.findViewById<TextView>(R.id.txt_placeName)
    val txt_distance = itemView.findViewById<TextView>(R.id.txt_distance)
    val txt_thumbUp = itemView.findViewById<TextView>(R.id.txt_thumbUp)
    val txt_thumbDown = itemView.findViewById<TextView>(R.id.txt_thumbDown)

    fun bind(placeData: PlaceData) {
        Glide.with(itemView).load(placeData.img_place).apply(RequestOptions().transforms(CenterCrop(),RoundedCorners(20))).into(img_place)

        txt_placeName.text = placeData.txt_place
        txt_distance.text = placeData.txt_distance
        txt_thumbUp.text = placeData.txt_thumbUp
        txt_thumbDown.text = placeData.txt_thumbDown

        if(placeData.img_bookmark){
            bookmark.setImageResource(R.drawable.icon_bookmark_selected)
        }else{
            bookmark.setImageResource(R.drawable.icon_bookmark)
        }
    }

    init {
        itemView.setOnClickListener {
            clickListener.onClickItem(adapterPosition)
        }

        itemview.img_bookmark.setOnClickListener {
            clickBookmark.onClickBookmark(adapterPosition)
        }
    }

    interface onClickListener {
        fun onClickItem(position: Int)
    }

    interface onClickBookmark{
        fun onClickBookmark(position: Int)
    }

}
