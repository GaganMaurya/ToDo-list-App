package com.example.todoapp

import com.example.todoapp.room.roomEntity

object dataobject {
    var list =  arrayListOf<roomEntity>()

    fun setdata(t : String ,  p : String){
        list.add(roomEntity(0,t, p))
    }

    fun getalldata(): List<roomEntity>{
        return  list
    }

    fun deleteall(){
        list.clear()
    }

    fun getdata(pos : Int) : roomEntity{
        return list[pos]
    }

    fun delete(p : Int){
        list.removeAt(p)
    }

    fun updatedata(po : Int , t : String , pri : String){
        list[po].name =  t
        list[po].pri =  pri
    }
}