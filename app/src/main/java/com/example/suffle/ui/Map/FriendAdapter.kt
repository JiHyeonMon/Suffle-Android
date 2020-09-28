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
import com.example.suffle.data.NormalPersonData
import kotlinx.android.synthetic.main.item_act_create_friend.view.*


class FriendAdapter (private val context: Context, private val clickListener: FriendViewHolder.onClickListener): RecyclerView.Adapter<FriendViewHolder>(){

    var datas = mutableListOf<NormalPersonData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_act_create_friend, parent, false)
        return FriendViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }

}

class FriendViewHolder(itemview: View, val clickListener: onClickListener) : RecyclerView.ViewHolder(itemview){
    val img_person = itemView.findViewById<ImageView>(R.id.item_act_create_friend_img)
    val txt_personName = itemView.findViewById<TextView>(R.id.item_act_create_friend_txt_person)

    fun bind(normalPersonData: NormalPersonData) {
        Glide.with(itemView).load(normalPersonData.img_person).circleCrop().into(img_person);
        txt_personName.text = normalPersonData.txt_personName
    }

    init {
        itemView.item_act_create_friend_btn.setOnClickListener {
            clickListener.onClickItem(adapterPosition)
        }
    }

    interface onClickListener {
        fun onClickItem(position: Int)
    }
}