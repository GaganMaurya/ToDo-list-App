package com.example.todoapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class roomEntity (
   @PrimaryKey(autoGenerate = true)
   var uid :  Int  ,
    @ColumnInfo("name")var name  : String,
    @ColumnInfo("pri")var pri  : String

    )