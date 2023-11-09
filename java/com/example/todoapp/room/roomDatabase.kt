package com.example.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [roomEntity::class] , version = 1)
abstract class roomDatabase : RoomDatabase(){
    abstract fun getdao() : roomDao
}