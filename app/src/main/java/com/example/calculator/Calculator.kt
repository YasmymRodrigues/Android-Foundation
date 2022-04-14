package com.example.calculator

import net.objecthunter.exp4j.ExpressionBuilder

class Calculator {

    var expression: String = "0"
    private val history = mutableListOf<Operation>()

    fun insertSymbol(symbol: String): String {
        return expression
    }

    fun performOperation(): Double {
        val expressionBuilder = ExpressionBuilder(expression).build()
        val result = expressionBuilder.evaluate()
        history.add(Operation(expression, result))
        return result
    }
}

