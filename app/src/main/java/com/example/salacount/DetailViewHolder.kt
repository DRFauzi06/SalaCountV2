package com.example.salacount

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailViewHolder(inflater: LayoutInflater, parent:ViewGroup):RecyclerView.ViewHolder(inflater.inflate(R.layout.item_detail,parent,false)) {

    private var no:TextView? = null
    private var namaBaju:TextView? = null
    private var hrgBaju:TextView? = null
    private var jmlBaju:TextView? = null
    private var sttBaju:TextView? = null

    init {
        no = itemView.findViewById(R.id.noBarang)
        namaBaju = itemView.findViewById(R.id.namaBarang)
        hrgBaju = itemView.findViewById(R.id.hargaBarang)
        jmlBaju = itemView.findViewById(R.id.jumlahBarang)
        sttBaju = itemView.findViewById(R.id.subtotalBarang)
    }

    fun bind(data: DetailKerja){
        no?.text = data.no.toString()
        namaBaju?.text = data.namaBaju
//        Log.d("Jumlah Baju bind nama: ",namaBaju.toString())
        hrgBaju?.text = data.hrgBaju.toString()
//        Log.d("Jumlah Baju bind harga: ",hrgBaju.toString())
        jmlBaju?.text = data.jmlBaju.toString()
//        Log.d("Jumlah Baju bind: ",jmlBaju.toString())
        sttBaju?.text = data.sttBaju.toString()
    }
}