package com.example.celular.recicleView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.celular.R
import com.example.celular.conection.Db
import com.example.celular.model.Book
import kotlinx.android.synthetic.main.activity_recicle_book.*

class RecicleBook : AppCompatActivity() {
    val db: Db by lazy {
        Room.databaseBuilder(this, Db::class.java, "DataBaseBooks")
            .allowMainThreadQueries().build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicle_book)

        var adapter = AdapterBook(this,db.BookIT().listAll())
        recyclerview.adapter = adapter

        val layout = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerview.layoutManager = layout

    }
}
