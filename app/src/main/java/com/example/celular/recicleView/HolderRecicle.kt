package com.example.celular.recicleView

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.celular.R

class HolderRecicle(v:View): RecyclerView.ViewHolder(v){
    val nameCdBook:TextView = v.findViewById(R.id.nameBook)
    val imgBookCd:ImageView = v.findViewById(R.id.imgBooks)
    val layoutNormal:LinearLayout = v.findViewById(R.id.layout_normal)
    val layoutGone:LinearLayout = v.findViewById(R.id.layout_gone)

    val undoButton:Button = v.findViewById(R.id.undo_button)
}
