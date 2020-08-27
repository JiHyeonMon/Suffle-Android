package com.example.suffle.ui.Home.alert

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suffle.R
import com.example.suffle.data.PersonListData
import kotlinx.android.synthetic.main.item_alert.view.*

class AlertAdpater(
    private val context: Context,
    private val deleteClickListener: AlertViewHolder.onDeleteClickListener,
    private val allowClickListener: AlertViewHolder.onAllowClickListener
): RecyclerView.Adapter<AlertViewHolder>(){
    var datas = mutableListOf<PersonListData>()
    var previousPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_alert, parent, false)
        return AlertViewHolder(view, deleteClickListener, allowClickListener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: AlertViewHolder, position: Int) {
        holder.bind(datas[position])
        previousPosition = position
    }
}

class AlertViewHolder(
    itemview: View,
    val DeleteClick: onDeleteClickListener,
    val AllowClick: onAllowClickListener
) : RecyclerView.ViewHolder(itemview) {

    val item_alert_img = itemview.findViewById<ImageView>(R.id.item_alert_img)
    val item_alert_name = itemview.findViewById<TextView>(R.id.item_alert_name)

    fun bind(personListData: PersonListData){
        Glide.with(itemView).load(personListData.img_person).into(item_alert_img)
        item_alert_name.text = personListData.txt_personName
    }

    init {
        itemview.item_alert_delete.setOnClickListener {
            DeleteClick.onDeleteClick(adapterPosition)
        }

        itemview.item_alert_allow.setOnClickListener {
            AllowClick.onAllowClick(adapterPosition)
        }
    }

    interface onDeleteClickListener {
        fun onDeleteClick(position: Int)
    }

    interface onAllowClickListener {
        fun onAllowClick(position: Int)
    }
}