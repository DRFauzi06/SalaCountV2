package com.example.salacount

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView



class HistoryViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_history,parent,false)) {
    private var hNamaPekerja: TextView? = null
    private var hGajiPekerja: TextView? = null
    private var hTanggal: TextView? = null
    private var hDetail: TextView? = null



    init {
        hNamaPekerja = itemView.findViewById(R.id.hNamaPekerja)
        hGajiPekerja = itemView.findViewById(R.id.hGajiPekerja)
        hTanggal = itemView.findViewById(R.id.hTanggal)
        hDetail = itemView.findViewById((R.id.textViewOptions))

    }

    fun bind(data: DetailBayar){
        hNamaPekerja?.text = data.namaPekerja
        hGajiPekerja?.text = data.totalAll
//        Log.d("Jumlah Baju bind nama: ",namaBaju.toString())
        hTanggal?.text = data.tanggal.toString()
//        Log.d("Jumlah Baju bind harga: ",hrgBaju.toString())
//        hDetail?.text = data.baju1.toString()

//        Log.d("Jumlah Baju bind: ",jmlBaju.toString())

    }
}
