package com.example.celular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.room.Room
import com.example.celular.conection.Db
import com.example.celular.model.Book
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.activity_register_book.*

class Books : AppCompatActivity() {
    val db: Db by lazy {
        Room.databaseBuilder(this, Db::class.java, "DataBaseBooks")
            .allowMainThreadQueries().build()
    }
    var books =  ArrayList<Book>()
    var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        newBook()
        if (!books.isEmpty()){
            printBooks(position)
        }
        checkBack()
        checkNext()

        nextButton.setOnClickListener {
            printBooks(position++)
        }

        backButton.setOnClickListener {
            printBooks(position--)
        }




    }

    fun newBook(){
        db.BookIT().listAll().forEach {
            books.add(it)
        }
    }

    fun printBooks(posicion:Int){
        titleView.text = books.get(posicion).name
        authorView.text = books.get(posicion).author
        yearView.text = books.get(posicion).year.toString()
        noteView.text = books.get(posicion).note.toString()
    }

    fun checkNext(){
        if (position + 1 >= books.size) {
            nextButton.visibility = View.INVISIBLE
            true
        } else {
            nextButton.visibility = View.VISIBLE
            false
        }
    }

    fun checkBack(){
        if (position - 1 < 0) {
            backButton.visibility = View.INVISIBLE
            true
        } else {
            backButton.visibility = View.VISIBLE
            false
        }
    }

}
