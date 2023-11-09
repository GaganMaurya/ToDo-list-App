package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface roomDao {
    @Query(" Select * From roomEntity")
    fun getdata() : List<roomEntity>


    @Insert
    fun insert(roomEntity: roomEntity)

    @Delete
    fun delete( r : roomEntity)

    @Update
    fun update(r : roomEntity)

    @Query("Delete From roomEntity ")
    fun deleteall()


}