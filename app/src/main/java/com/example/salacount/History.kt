package com.example.salacount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

lateinit var database: DatabaseReference
lateinit var userList: ArrayList<DetailBayar>
lateinit var recyclerView: RecyclerView
lateinit var detailAdapter: GajiAdapter


class History : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        recyclerView = findViewById(R.id.recycleHistory)
        userList = arrayListOf<DetailBayar>()
        getuserData()
        Log.d("DataUser", userList.toString())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(false)
    }
}



private fun getuserData() {
    database = FirebaseDatabase.getInstance("https://salacount-464c3-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("detailKerja")
    database.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            userList.clear()
            if (snapshot.exists()) {
                for (usersnap in snapshot.children) {
                    val userData = usersnap.getValue(DetailBayar::class.java)
                    userList.add(userData!!)
                    Log.d("DataUser", userList.toString())
                }
                detailAdapter = GajiAdapter(userList)

//                userAdapter = UserAdapter(userList, this@listFragment)
                recyclerView.adapter = detailAdapter

//val intent = Intent(this,DetailKerjaan::class.java)
            }

        }
        override fun onCancelled(error: DatabaseError) {

            Log.d("DataUser", userList.toString())

        }

    })
}
