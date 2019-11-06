package com.example.celular.adptergrid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.celular.R
import com.example.celular.model.Book

class AdpterGrid(var context: Context, var listBooks:List<Book>): BaseAdapter()  {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v = LayoutInflater.from(context).inflate(R.layout.booklistgrid, parent, false)
        var name = v.findViewById<TextView>(R.id.nameBook)

        var bookit = listBooks.get(position)

        name.text = bookit.name

        return v
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