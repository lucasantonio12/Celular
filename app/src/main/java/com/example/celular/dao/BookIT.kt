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
    @Query("SELECT * FROM BOOK")

    fun listAll(): Array<Book>
    @Query("SELECT * FROM BOOK WHERE id = :id")

    fun findById(id: Long): Book
    @Query("SELECT * FROM BOOK WHERE name = :name")

    fun findByName (name: String) : Book
}