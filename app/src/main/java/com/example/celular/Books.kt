package com.example.celular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

       if(position < books.size){

           nextButton.isInvisible = false

           nextButton.setOnClickListener {
               position++
               printBooks(position)
           }

        }else{
           nextButton.isInvisible = true
       }
        if(position > 0){

            backButton.isInvisible = false

            backButton.setOnClickListener {
                position--
                printBooks(position)
            }

        }else{
            backButton.isInvisible = true
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


}
