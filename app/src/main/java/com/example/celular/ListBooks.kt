package com.example.celular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.room.Room
import com.example.celular.conection.Db
import com.example.celular.model.Book
import kotlinx.android.synthetic.main.activity_list_books.*
import java.util.*
import kotlin.collections.ArrayList

class ListBooks : AppCompatActivity() {
    var booksList = ArrayList<String>()

    val db: Db by lazy {
        Room.databaseBuilder(this, Db::class.java, "DataBaseBooks")
            .allowMainThreadQueries().build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_books)

        var bookAutComplete = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,booksList)
        newList()

        autocomplete.setAdapter(bookAutComplete)
        autocomplete.setOnItemClickListener { adapterView, view, i, l ->
            var selected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "$selected foi Selecionado", Toast.LENGTH_SHORT).show()
        }

    }

    fun newList(){
        db.BookIT().listAll().forEach {
            booksList.add(it.name)
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
