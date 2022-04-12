package com.example.calculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val model = Calculator()

    fun getDisplayValue() = model.expression

    fun onClickSymbol(symbol: String): String {
        return model.insertSymbol(symbol)
    }

    fun onClickEquals(): String {
        val result = model.performOperation()
        return result.toString()
    }
}