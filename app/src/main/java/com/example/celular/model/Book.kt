package com.example.celular.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "table_books")
data class Book(var name:String, var author:String, var year:Int, var note:Float){
    @PrimaryKey (autoGenerate = true)
    var id = 0
}