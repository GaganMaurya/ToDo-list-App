package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.todoapp.databinding.ActivityMain2Binding
import com.example.todoapp.room.roomDatabase
import com.example.todoapp.room.roomEntity

class update : AppCompatActivity() {
    lateinit var b : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b =  ActivityMain2Binding.inflate(layoutInflater)
        setContentView(b.root)
        val room =  Room.databaseBuilder(this , roomDatabase::class.java ,"roomEntity")
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()

        val db = room.getdao()

        var position =  intent.getIntExtra("id" , -1)
        if(position != -1){
            val title = dataobject.getdata(position).name
            val pri = dataobject.getdata(position).pri
            b.createTitle.setText(title)
            b.createPriority.setText(pri)

            b.deleteButton.setOnClickListener {

                db.delete(roomEntity(position+1 , title ,pri))
                myintent()
            }
            b.updateButton.setOnClickListener {

                db.update(roomEntity(position+1, b.createTitle.text.toString() , b.createPriority.text.toString()))
                myintent()
            }
        }

    }

    fun myintent(){
        val intent =  Intent(this , MainActivity::class.java)
        startActivity(intent)
    }
}