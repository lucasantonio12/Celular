package com.example.celular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            var i = Intent(this,Books::class.java)
            startActivity(i)
        }

    }
}
