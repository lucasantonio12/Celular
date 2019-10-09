package com.example.celular.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.celular.R
import com.example.celular.model.Book

class BooksAdpter(var context:Context, var listBooks:List<Book>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewBooks = LayoutInflater.from(context).inflate(R.layout.booksview, parent, false)
        var name = viewBooks.findViewById<TextView>(R.id.nameBook)
        //var image = viewBooks.findViewById<ImageView>(R.id.imageBook)
        var bookCurrent = listBooks.get(position)
        name.text = bookCurrent.name

        return viewBooks
    }

    override fun getItem(position: Int): Any {
        return listBooks.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
       return listBooks.size
    }

}