package com.algebra.testing

interface BookService {

    fun inStock(bookId: Int): Boolean
    fun lend(bookId: Int, memberId: Int)
    fun returnBook(bookId: Int, memberId: Int): Boolean
    fun updateStock(bookId: Int)

}