package com.example.celular.adptergrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.celular.R
import com.example.celular.adpter.BooksAdpter
import com.example.celular.conection.Db
import com.example.celular.model.Book
import kotlinx.android.synthetic.main.activity_grid_view.*
import kotlinx.android.synthetic.main.activity_list_view_books.*

class GridView : AppCompatActivity() {
    val db: Db by lazy {
        Room.databaseBuilder(this, Db::class.java, "DataBaseBooks")
            .allowMainThreadQueries().build()
    }

    var bookList:List<Book> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        bookList = db.BookIT().listAll()

        gridviewad.adapter = AdpterGrid(this,bookList as List<Book>)
        gridviewad.setOnItemClickListener { parent, view, position, id ->
            var bookSelected = bookList?.get(position)
            Toast.makeText(this,"${bookSelected?.name} id : ${bookSelected?.id}",Toast.LENGTH_SHORT).show()
        }


    }
}
