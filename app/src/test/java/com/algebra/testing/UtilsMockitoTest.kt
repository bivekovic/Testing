package com.algebra.testing

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UtilsMockitoTest {

    private lateinit var bookService: BookService

    @Before
    fun setup() {
        bookService = mock()
    }

    @Test
    fun bookIsSuccessfullyLent() {
        whenever(bookService.inStock(any())).thenReturn(true)

        val manager = BookManager(bookService)
        manager.checkout(100, 1)
        verify(bookService).lend(100, 1)
    }

    @Test(expected = IllegalStateException::class)
    fun exceptionIsThrownWhenNoBooksAvailableInStock() {

        whenever(bookService.inStock(any())).thenReturn(false)

        val manager = BookManager(bookService)
        manager.checkout(100, 1)
    }

    @Test
    fun bookIsSuccessfullyReceivedBackAndStockUpdated() {
        whenever(bookService.returnBook(any(), any())).thenReturn(true)

        val manager = BookManager(bookService)
        manager.receive(100, 1)
        verify(bookService).updateStock(100)
    }

    @Test(expected = IllegalStateException::class)
    fun exceptionIsThrownWhenBookOrMemberUnknown() {
        whenever(bookService.returnBook(any(), any())).thenReturn(false)

        val manager = BookManager(bookService)
        manager.receive(100, 1)
    }

}
