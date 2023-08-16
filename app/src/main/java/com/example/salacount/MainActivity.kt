package com.example.salacount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.TimeZone

class MainActivity : AppCompatActivity() {


    val apiUrl = "https://script.google.com/macros/s/AKfycbx37MGcoB1UCuw4a6p_44Li_Lx4Uc4VYZOxCGaKp_hLnbLyXUAA19mhtBVAQybzySBS/exec"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image_view = findViewById<ImageView>(R.id.gambarMenu1)
        val image_view2 = findViewById<ImageView>(R.id.gambarMenu2)
        var noBarang: MutableList<String> = ArrayList()
        var namaBarang: MutableList<String> = ArrayList()
        var hargaBarang: MutableList<String> = ArrayList()
        var namaPekerja: MutableList<String> = ArrayList()


//        var waktu = TimeZone.getDefault().getDisplayName()

//        Log.d("Waktu ", timestamp.toString())


        //API CALL DATA
        val reqQueue : RequestQueue = Volley.newRequestQueue(this)
        val request = JsonObjectRequest(Request.Method.GET,apiUrl,null,{ res->
            Log.d("Volley sample1", res.toString())
            val jsonArray = res.getJSONArray("data")
            Log.d("Volley sample2", jsonArray.toString())

            for (i in 0  until jsonArray.length()){
                val jsonObj = jsonArray.getJSONObject(i)
                Log.d("volley sample3", jsonObj.toString())



                namaBarang.add(jsonObj["Nama"].toString())
                noBarang.add(jsonObj["No"].toString())
                hargaBarang.add(jsonObj["Harga"].toString())
                namaPekerja.add(jsonObj["Pekerja"].toString())
//                val dataBarang = barang(
//                    jsonObj.getInt("No"),
//                    jsonObj.getString("Nama"),
//                    jsonObj.getInt("Harga")
//                )
//                barangList.add(dataBarang);
//                Log.d("Volley sample",barangList.toString())
                val produk = arrayOf(namaBarang)
                Log.d("Volley Sample4", namaBarang.toString())
//                Log.d("Volley Sample6", produk.toString())


            }
            image_view2.setOnClickListener{
                val intent = Intent(this@MainActivity, Count::class.java)
                intent.putExtra("produk",ArrayList(namaBarang))
                intent.putExtra("harga",ArrayList(hargaBarang))
                intent.putExtra("pekerja",ArrayList(namaPekerja))
                startActivity(intent)

            }
            image_view.setOnClickListener{
                var intent = Intent(this@MainActivity, History::class.java)

                intent.putExtra("produk",ArrayList(namaBarang))
                intent.putExtra("harga",ArrayList(hargaBarang))
                intent.putExtra("pekerja",ArrayList(namaPekerja))
                startActivity(intent)

            }



        },{err->
            Log.d("Volley sample", err.message.toString())
        })
        reqQueue.add(request)
        Log.d("Volley Sample5", namaBarang.toString())







    }
}