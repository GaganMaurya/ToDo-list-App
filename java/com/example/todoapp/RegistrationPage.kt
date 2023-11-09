package com.example.todoapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.todoapp.databinding.ActivityRegistrationPageBinding

class RegistrationPage : AppCompatActivity() {
    lateinit var b : ActivityRegistrationPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityRegistrationPageBinding.inflate(layoutInflater)
        setContentView(b.root)


        b.btn.setOnClickListener {
            if(b.name.text!!.isNotEmpty() && b.email.text!!.isNotEmpty() && b.pass.text!!.isNotEmpty()){
                adddata()

            }
            else{
                Toast.makeText(this, "Please fill all the entries", Toast.LENGTH_SHORT).show()
            }
        }
        b.already.setOnClickListener {
            startActivity(Intent(this , LoginPage::class.java))

        }

    }

    private fun adddata() {
        val db = Dbhelper(this, null)

        val name = b.name.text.toString()
        val email = b.email.text.toString()
        val pass = b.pass.text.toString()

        db.adddata(name, email, pass)

        val sharedp: SharedPreferences = getSharedPreferences("hello", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedp.edit()
        editor.apply {

            putString("key1", "1")
            putString("key2", b.name.text.toString())


        }.apply()

        Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)


    }

    }