package com.algebra.testing.utils

fun add( number1 : Int, number2 : Int ) : Int {
    return number1 + number2
}

fun subtract( number1 : Int, number2 : Int) : Int {
    return number1 - number2
}

fun multiply( number1 : Int, number2 : Int ) : Int {
    return number1 * number2
}

fun divide( number1: Int, number2: Int ) : Int {
    if ( number2 == 0 )
        return 0
    return number1 / number2
}

fun transformToNumber(value: String): Int? {
    if( value.isEmpty( ) )
        return null
    return try {
        value.toInt( )
    } catch ( e : Exception ) {
        null
    }
}