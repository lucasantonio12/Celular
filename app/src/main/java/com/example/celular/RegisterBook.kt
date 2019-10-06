package com.example.celular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.celular.conection.Db
import com.example.celular.model.Book
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.activity_register_book.*


class RegisterBook : AppCompatActivity() {
    val db: Db by lazy {
        Room.databaseBuilder(this, Db::class.java, "DataBaseBooks")
            .allowMainThreadQueries().build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_book)


        saveButton.setOnClickListener {
            db.BookIT().inserir(Book(titleText.text.toString(), authorText.text.toString(), yearText.text.toString().toInt(), noteText.rating))
            db.BookIT().listAll().forEach { Log.i("Book",it.toString())}

            titleText.setText("")
            authorText.setText("")
            yearText.setText("")
            noteText.rating = 0f
        }

        cancelButton.setOnClickListener {
                var i = Intent(this, Home::class.java)
                 startActivity(i)
                finish()
            }
        }
}
