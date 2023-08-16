package com.example.salacount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.salacount.databinding.ActivityCountBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

class Count : AppCompatActivity() {

    private lateinit var binding:ActivityCountBinding
    private lateinit var database:DatabaseReference
    private lateinit var database2:DatabaseReference
    private lateinit var database3:DatabaseReference

    val calendar =Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")

    lateinit var recyclerView: RecyclerView
    lateinit var recycleAdapter: DetailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)
        val namaProduk = intent.getParcelableArrayListExtra<Barang>("produk") as ArrayList<String>
        val hargaProduk = intent.getParcelableArrayListExtra<harga>("harga") as ArrayList<String>
        val namaPekerja = intent.getParcelableArrayListExtra<Pekerja>("pekerja") as ArrayList<String>
        val spinner = findViewById<Spinner>(R.id.spinnerBaju)
        val spinner2 = findViewById<Spinner>(R.id.spinnerPekerja)
        var namaKaryawan =""
        var namaBaju=ArrayList<String>()
        var jumlah=ArrayList<Int>()
        var hargaBaju=ArrayList<Int>()
        var subTotal=ArrayList<Int>()
        var hitung = 1
        var pos = 0
        var totalGaji =0
        var tampil=0

        val timestamp = ZonedDateTime.now(ZoneId.of("Asia/Bangkok"))
            .format(DateTimeFormatter.ofPattern("MM-dd-yyy "))



        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, namaProduk)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, namaPekerja)
        spinner.adapter = adapter
        spinner2.adapter = adapter2
        //get jumlah
            spinner.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener{

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                    namaBaju = namaProduk[p2].toString()
                    pos = p2

                    Log.d("Volley Sampe11", hargaBaju.toString())
//                    Log.d("Volley Sampe11", jumlah.toString())

//                    val jumlah:Int =
//                    Toast.makeText(applicationContext,"selected value = "+namaProduk[p2], Toast.LENGTH_SHORT).show()
                 }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    namaBaju.clear()
                }


            }
        //get namaPekerja
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                namaKaryawan = namaPekerja[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        val total:TextView = findViewById(R.id.totalAll) as TextView

        val klikTambah = findViewById<Button>(R.id.buttonTambah)
        klikTambah.setOnClickListener{
            namaBaju.add(namaProduk[pos])


            hargaBaju.add(hargaProduk[pos].toInt())


//            namaBaju.add(namaProduk[pos])
            jumlah.add(findViewById<EditText>(R.id.jumlahBaju1).text.toString().toInt())
            subTotal.add(hargaBaju[tampil]*jumlah[tampil])
            tampil++

            totalGaji = subTotal.sum()
            total.text = totalGaji.toString()

            Log.d("Jumlah Baju : ",jumlah.toString())

            addData(hitung,namaBaju,hargaBaju,jumlah,subTotal)
//            add(hitung,namaBaju,hargaBaju,jumlah,subTotal)
//            init(hitung,namaBaju,hargaBaju,jumlah,subTotal)
//            init(hitung,namaBaju,hargaBaju,jumlah,subTotal)
            Log.d("Jumlah Baju 2 : ",jumlah.toString())
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = recycleAdapter
            hitung++
            Log.d("Jumlah Baju 3 : ",hitung.toString())

        }

        val klikSubmit = findViewById<Button>(R.id.buttonSubmit)
        klikSubmit.setOnClickListener{

//            database("https://salacount-464c3-default-rtdb.asia-southeast1.firebasedatabase.app/")
            database = FirebaseDatabase.getInstance("https://salacount-464c3-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("detailKerja")
            val tanggal = ""
            val userId: String? = database.push().key


            val max = subTotal.size
            val tgl = tglDetail(tanggal)
            val namaPekerja = namaKaryawan
            val detil = DataDetail(namaKaryawan,namaBaju.toString(),hargaBaju.toString(), jumlah.toString(),subTotal.toString(),totalGaji.toString(),timestamp)

            database.child(userId.toString()).setValue(detil).addOnSuccessListener {

                Toast.makeText(this,"Berhasil disimpan",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{

                Toast.makeText(this," disimpan",Toast.LENGTH_SHORT).show()
            }
//            database.child(namaKaryawan).setValue(detil).
//            database.setValue(detil)
//            database.child(namaKaryawan).setValue(tgl)
//            database2 = FirebaseDatabase.getInstance("https://salacount-464c3-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("detailKerja/"+namaKaryawan)
//            val bayar = bayaranDetail(totalGaji.toString())
//            database2.child(tanggal).setValue(bayar)

//            for (i in 0 until max){
//
//                val id = idDetail(i)
////                database2.setValue(id)
////                database3 = FirebaseDatabase.getInstance("https://salacount-464c3-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("detailKerja/"+tanggal+"/"+namaKaryawan)
//
//                for (j in 0 until max){
//                    val detilBaju = BajuDetail(namaBaju[i],hargaBaju[i].toString(), jumlah[i].toString(),subTotal[i].toString())
//
//
//
//
////                database.child(namaKaryawan).setValue(detilBaju)
////                database.isChild(namaKaryawan)child(i.toString())).setValue(detilBaju)
//
//
//            }
//            }
            recreate()
            overridePendingTransition(0, 0);
        }

    }
    private fun addData(no:Int, baju:List<String>, hrg:List<Int>, jml:List<Int>,stt:List<Int>){
        recyclerView = findViewById(R.id.recycleDetail)


        var data = ArrayList<DetailKerja>()
        for(i in 0 until no) {
            Log.d("Jumlah Baju 1  : ",jml.toString())
            Log.d("Jumlah Baju 11  : ",stt.toString())

            data.add(DetailKerja(i+1, baju[i], hrg[i], jml[i], stt[i]))



        }
        recycleAdapter = DetailAdapter(data)







    }
//     protected  fun init(no:Int, baju:List<String>, hrg:List<Int>, jml:List<Int>,stt:List<Int>){
//        recyclerView = findViewById(R.id.recycleDetail)
//
//
//        var i = 0
//        var data = ArrayList<DetailKerja>()
//        for(i in 0 until no) {
//            Log.d("Jumlah Baju 1  : ",jml.toString())
////        data.add(DetailKerja(0,"Kancing",5000,10,50000))
////        data.add(DetailKerja(1,"Demis",5000,10,50000))
////        data.add(DetailKerja(2,"Kancing",5000,10,50000))
////        data.add(DetailKerja(3,"Kancing",5000,10,50000))
//            data.add(DetailKerja(i, baju[i+1], hrg[i], jml[i], stt[i]))
//////            data.add(DetailKerja(no, baju[i], hrg[i], jml[i], hrg[i] * jml[i]))
//        }
//
//        recycleAdapter = DetailAdapter(data)
//
//
//    }
}