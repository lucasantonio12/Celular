package com.example.celular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.celular.adpter.ListViewBooks
import com.example.celular.recicleView.RecicleBook
import kotlinx.android.synthetic.main.activity_grid_view.*
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

        gridViewButton.setOnClickListener {
            var i = Intent(this,gridviewad::class.java)
        }

        completTitles.setOnClickListener {
            var i = Intent(this,ListBooks::class.java)
            startActivity(i)
        }

        listTitulos.setOnClickListener {
            var i = Intent(this,ListViewBooks::class.java)
            startActivity(i)
        }

        recicleButton.setOnClickListener{
            var i = Intent(this,RecicleBook::class.java)
            startActivity(i)
        }


    }
}
