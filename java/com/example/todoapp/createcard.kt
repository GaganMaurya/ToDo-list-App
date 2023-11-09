package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.todoapp.databinding.ActivityCreatecardBinding
import com.example.todoapp.room.roomDatabase
import com.example.todoapp.room.roomEntity

class createcard : AppCompatActivity() {
    lateinit var b : ActivityCreatecardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityCreatecardBinding.inflate(layoutInflater)
        setContentView(b.root)

        val room =  Room.databaseBuilder(this , roomDatabase::class.java ,"roomEntity")
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()

        val db = room.getdao()

        b.saveButton.setOnClickListener {
            if(b.createTitle.text.isNotEmpty() && b.createPriority.text.isNotEmpty()){
                var t =  b.createTitle.text.toString()
                var p =  b.createPriority.text.toString()
                dataobject.setdata(t,p)

                db.insert(roomEntity(0,t,p))
                val i  = Intent(this ,  MainActivity::class.java)
                startActivity(i)

            }
        }


    }
}