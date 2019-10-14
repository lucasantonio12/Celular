package com.example.celular.recicleView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.celular.R
import com.example.celular.model.Book

class AdapterBook(var context: Context, var listBooks:List<Book>) : RecyclerView.Adapter<HolderRecicle>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderRecicle {
        val view = LayoutInflater.from(context).inflate(R.layout.carlayout,parent,false)
        return  HolderRecicle(view)
    }

    override fun getItemCount(): Int {
        return listBooks.size
    }

    override fun onBindViewHolder(holder: HolderRecicle, position: Int) {
        val bookSelect = listBooks[position]
        holder.nameCdBook.text = bookSelect.name
        holder.imgBookCd.setImageResource(R.drawable.bookicons)

        holder.imgBookCd.setOnClickListener {
            holder.imgBookCd.setImageResource(R.drawable.imageopen)
        }
        

    }


}