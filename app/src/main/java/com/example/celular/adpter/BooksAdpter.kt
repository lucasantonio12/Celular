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
        var holder:ViewHolder
        var view:View

        if (convertView == null){
             view = LayoutInflater.from(context).inflate(R.layout.booksview, parent, false)
             holder = ViewHolder(view)
             view.tag = holder
        }else{
            view = convertView
            holder  = convertView.tag as ViewHolder
        }

        val bookSelect = listBooks[position]
        holder.titleBook.text = bookSelect.name
        holder.authorBook.text = bookSelect.author
        holder.noteBook.text = bookSelect.note.toString()

        return view
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