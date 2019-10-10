package com.example.celular.adpter

import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.celular.R

class ViewHolder(v:View) {
    val titleBook:TextView
    val authorBook:TextView
    val noteBook:TextView

    init {
        Log.i("HOLDER", "Fazendo buscas por id...")
        titleBook = v.findViewById(R.id.titleBook)
        authorBook = v.findViewById(R.id.authorBook)
        noteBook = v.findViewById(R.id.noteBook)
    }
}