package com.example.celular.dao

import androidx.room.*
import com.example.celular.model.Book

@Dao
interface BookIT{
    @Insert
    fun inserir(book: Book): Long

    @Delete
    fun deletar(book: Book): Int

    @Update
    fun atualizar(book: Book): Int
    @Query("SELECT * FROM table_books")

    fun listAll(): Array<Book>
    @Query("SELECT * FROM table_books WHERE id = :id")

    fun findById(id: Long): Book
    @Query("SELECT * FROM table_books WHERE name = :name")

    fun findByName (name: String) : Book
}