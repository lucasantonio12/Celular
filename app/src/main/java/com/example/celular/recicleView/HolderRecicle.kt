package com.example.celular.recicleView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.celular.R

class HolderRecicle(v:View): RecyclerView.ViewHolder(v){
    val nameCdBook:TextView
    val imgBookCd:ImageView
    init {
        nameCdBook = v.findViewById(R.id.nameCdBook)
        imgBookCd = v.findViewById(R.id.imgBookCd)

        imgBookCd.setOnClickListener {
            imgBookCd.setImageResource(R.drawable.imageopen)
        }
    }
}
