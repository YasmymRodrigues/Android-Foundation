package com.example.calculator

class OperationUi(val expression: String, val result: String, val timeStamp: Long) {
    override fun toString(): String {
        return "OperationUi(expression='$expression', result='$result', timeStamp=$timeStamp)"
    }
}