package com.example.celular.recicleView

import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.celular.R
import com.example.celular.model.Book
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class AdapterBook(var context: Context, var listBooks:MutableList<Book>) : RecyclerView.Adapter<HolderRecicle>() {
    private val PENDING_REMOVAL_TIMEOUT:Long = 2000
    var itemsPendingRemoval = ArrayList<Book>()

    private val handler = Handler()
    var pendingRunnables: HashMap<Book, Runnable> =
        HashMap()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderRecicle {
        val view = LayoutInflater.from(context).inflate(R.layout.layoutdragdrop,parent,false)
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

        if (itemsPendingRemoval.contains(bookSelect)){
            holder.layoutNormal.setVisibility(View.GONE)
            holder.layoutGone.setVisibility(View.VISIBLE)
            holder.undoButton.setVisibility(View.VISIBLE)
            holder.undoButton.setOnClickListener {
                val pendingRemovalRunnable = pendingRunnables[bookSelect]
                Log.i("AULA17", "CLICOU")
                pendingRunnables.remove(bookSelect)
                if (pendingRemovalRunnable != null) {
                    handler.removeCallbacks(pendingRemovalRunnable)
                }
                itemsPendingRemoval.remove(bookSelect)
                //binda novamente para redesenhar
                notifyItemChanged(listBooks.indexOf(bookSelect))
            }
        }else{
            holder.nameCdBook.setText(bookSelect.name)
            holder.layoutNormal.setVisibility(View.VISIBLE)
            holder.layoutGone.setVisibility(View.GONE)
            holder.undoButton.setVisibility(View.GONE)
            holder.undoButton.setOnClickListener(null)
            holder.imgBookCd.setOnClickListener {
                holder.imgBookCd.setImageResource(R.drawable.imageopen)
                notifyItemChanged(position)
            }
        }
    }

    fun remove (position: Int){
        var book = listBooks[position]

        if (listBooks.contains(book)){
            listBooks.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun removeTime(position: Int) {

        val book = listBooks[position]
        if (!itemsPendingRemoval.contains(book)) {
            itemsPendingRemoval.add(book)
            notifyItemChanged(position)
            var pendingRemovalRunnable = Runnable {
                remove(position)
            }
            handler.postDelayed(pendingRemovalRunnable, PENDING_REMOVAL_TIMEOUT)
            pendingRunnables[book] = pendingRemovalRunnable
        }
    }

    fun mover(fromPosition: Int, toPosition: Int) {

        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(listBooks, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(listBooks, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        notifyItemChanged(toPosition)
        notifyItemChanged(fromPosition)
    }
}