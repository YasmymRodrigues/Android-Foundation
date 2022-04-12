package com.example.calculator

import net.objecthunter.exp4j.ExpressionBuilder

class Calculator {

    var display: String = "0"
    private val history = mutableListOf<Operation>

    fun insertSymbol(symbol: String): String {
        return display
    }

    fun performOperation(): Double {
        val expressionBuilder = ExpressionBuilder(display).build()
        val result = expressionBuilder.evaluate()
        history.add(Operation(display, result))
        return result
    }
}

