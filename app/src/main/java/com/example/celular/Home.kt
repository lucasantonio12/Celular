package com.example.celular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.celular.adpter.ListViewBooks
import kotlinx.android.synthetic.main.home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        registerButton.setOnClickListener {
            var i = Intent(this,RegisterBook::class.java)
            startActivity(i)
        }

        listButton.setOnClickListener {
            var i = Intent(this,ListBooksButtons::class.java)
            startActivity(i)
        }

        completTitles.setOnClickListener {
            var i = Intent(this,ListBooks::class.java)
            startActivity(i)
        }

        listTitulos.setOnClickListener {
            var i = Intent(this,ListViewBooks::class.java)
            startActivity(i)
        }

    }
}
