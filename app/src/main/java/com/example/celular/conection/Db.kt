package com.example.celular.conection

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.celular.dao.BookIT
import com.example.celular.model.Book

@Database(entities = [Book::class],version = 1)
abstract  class Db:RoomDatabase(){
    abstract  fun BookIT():BookIT
}