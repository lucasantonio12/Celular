package com.example.celular.recicleView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.celular.R
import com.example.celular.conection.Db
import com.example.celular.model.Book
import com.google.android.material.snackbar.Snackbar
import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator
import jp.wasabeef.recyclerview.animators.LandingAnimator
import kotlinx.android.synthetic.main.activity_recicle_book.*

class RecicleBook : AppCompatActivity() {
    val db: Db by lazy {
        Room.databaseBuilder(this, Db::class.java, "DataBaseBooks")
            .allowMainThreadQueries().build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicle_book)

        var bookList:MutableList<Book> = db.BookIT().listAll()

        var adapter = AdapterBook(this,db.BookIT().listAll())
        recyclerview.adapter = adapter

        val layout = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerview.layoutManager = layout

        recyclerview.addOnItemTouchListener(
            MyRecyclerViewClickListener(
                this@RecicleBook,
                recyclerview,
                object : MyRecyclerViewClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        Toast.makeText(this@RecicleBook, "Clique simples", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onItemLongClick(view: View, position: Int) {
                        val removida = bookList[position]
                        bookList.remove(removida)
                        recyclerview.adapter!!.notifyItemRemoved(position)
                        Toast.makeText(this@RecicleBook, "Clique longo", Toast.LENGTH_SHORT)
                            .show()
                        val snack = Snackbar.make(
                            recyclerview.parent as View,"Removido",Snackbar.LENGTH_LONG )
                            .setAction("Cancelar") {
                                bookList.add(position, removida)
                                recyclerview.adapter!!.notifyItemInserted(position)
                            }
                        snack.show()
                    }
                }
            )
        )
        recyclerview.itemAnimator = FlipInTopXAnimator()
    }
}
