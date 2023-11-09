package com.example.todoapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todoapp.databinding.ListContainerBinding
import com.example.todoapp.room.roomEntity
import java.util.Locale

class adapter(var c : Context, var list : List<roomEntity>) : Adapter<adapter.view>() {
    inner class view(v : View) : ViewHolder(v){
        var b  =   ListContainerBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view {
        return view(LayoutInflater.from(c).inflate(R.layout.list_container , parent , false))
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: view, position: Int) {
        var i = list[position]
        holder.b.tittle.text = i.name
        holder.b.pri.text = i.pri
        when(i.pri.lowercase(Locale.ROOT)){
            "high"->holder.b.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium"->holder.b.layout.setBackgroundColor(Color.parseColor("#EDC988"))
            else ->holder.b.layout.setBackgroundColor(Color.parseColor("#757575"))

        }
        holder.itemView.setOnClickListener {
        val i = Intent(c ,  update::class.java)
            i.putExtra("id" , position)
            c.startActivity(i)

        }
    }
}