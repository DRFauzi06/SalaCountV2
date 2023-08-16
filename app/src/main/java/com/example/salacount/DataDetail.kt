package com.example.salacount

data class DataDetail(val namaPekerja:String? = null, val baju1:String? = null,val hargaBaju:String? = null,val jumlahBaju:String? = null,val sttBaju:String? = null,val totalAll: String? = null, val tanggal:String? = null)

data class BajuDetail( val baju1:String? = null,val hargaBaju:String? = null,val jumlahBaju:String? = null,val sttBaju:String? = null)
data class idDetail(val id:Int? = null)
data class tglDetail(val tgl:String? =null)
//data class bayaranDetail(val totalAll:String? = null)
