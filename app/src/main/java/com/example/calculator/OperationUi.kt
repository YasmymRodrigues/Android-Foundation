package com.example.calculator

import android.widget.Toast

class OperationUi(val expression:String, val result: String, val timeStamp: Long) {
    override fun toString(): String {
        //Toast.makeText(this, timeStamp, Toast.LENGTH_LONG).show()
        return "OperationUi(expression='$expression', result='$result', timeStamp=$timeStamp)"
    }
}