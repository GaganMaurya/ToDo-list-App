package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.room.roomDatabase

class MainActivity : AppCompatActivity() {
    lateinit var b : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        val room =  Room.databaseBuilder(this ,roomDatabase::class.java ,"roomEntity")
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()

        val db = room.getdao()



        b.add.setOnClickListener {
           val intent = Intent(this , createcard::class.java)
           startActivity(intent)
        }



        b.deleteAll.setOnClickListener {
            dataobject.deleteall()
            db.deleteall()
            setrv()
        }

        setrv()
    }

    fun setrv(){
        val room =  Room.databaseBuilder(this , roomDatabase::class.java ,"roomEntity")
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()

        val db = room.getdao()
        val l = db.getdata()

        b.rv.layoutManager =  LinearLayoutManager(this)
        b.rv.adapter = adapter(this ,l)
    }
}