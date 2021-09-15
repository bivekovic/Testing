package com.algebra.testing

class BookManager(val bookService: BookService) {
    fun checkout(bookId: Int, memberId: Int) {
        if (bookService.inStock(bookId)) {
            bookService.lend(bookId, memberId)
        } else {
            throw IllegalStateException("Book is not available")
        }
    }

    fun receive(bookId: Int, memberId: Int) {
        if (bookService.returnBook(bookId, memberId)){
            bookService.updateStock(bookId)
        } else {
            throw IllegalStateException("Book or member unknown")
        }
    }
}
