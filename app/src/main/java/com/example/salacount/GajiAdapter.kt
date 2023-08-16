package com.example.salacount

import android.R
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class GajiAdapter(private val data: ArrayList<DetailBayar>): RecyclerView.Adapter<HistoryViewHolder>() {

    interface OptionsMenuClickListener {
        fun onOptionsMenuClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HistoryViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(data[position])




    }



    override fun getItemCount(): Int {
        return data.size
    }


//    class HistoryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//
//
//    }


}