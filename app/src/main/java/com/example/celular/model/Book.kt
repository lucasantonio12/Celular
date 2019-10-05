package com.example.celular.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class Book( var name:String, var author:String, var year:Int, var note:Float){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}