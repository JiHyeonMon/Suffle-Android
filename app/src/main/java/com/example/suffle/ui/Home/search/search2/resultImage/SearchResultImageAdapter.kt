package com.example.suffle.ui.Home.search.search2.resultImage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.MainRecommandData

class SearchResultImageAdapter (private val context: Context): RecyclerView.Adapter<SearchResultImageViewHolder>(){

    var datas = mutableListOf<MainRecommandData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultImageViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_frag_home_recommand, parent, false)
        return SearchResultImageViewHolder(view)    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: SearchResultImageViewHolder, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }

}


class SearchResultImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val img_food = itemView.findViewById<ImageView>(R.id.frag_home_img_recommand_food)

    fun bind(mainRecommandData: MainRecommandData){
        Glide.with(itemView).load(mainRecommandData.img_food).into(img_food)
    }
}