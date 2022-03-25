package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private val operations = mutableListOf<String>();
    private val adapter = HistoryAdapter(::onOperationClick)
    var exp: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "method 'onCreate' was called")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onStart() {
        super.onStart()
        binding.button0.setOnClickListener { onClickSymbol("0") }
        binding.button00?.setOnClickListener { onClickSymbol("00") }
        binding.button1.setOnClickListener { onClickSymbol("1") }
        binding.button2.setOnClickListener { onClickSymbol("2") }
        binding.button3.setOnClickListener { onClickSymbol("3") }
        binding.button4.setOnClickListener { onClickSymbol("4") }
        binding.button5.setOnClickListener { onClickSymbol("5") }
        binding.button6.setOnClickListener { onClickSymbol("6") }
        binding.button7?.setOnClickListener { onClickSymbol("7") }
        binding.button8?.setOnClickListener { onClickSymbol("8") }
        binding.button9?.setOnClickListener { onClickSymbol("9") }
        binding.buttonAdditon.setOnClickListener { onClickSymbol("+") }
        binding.buttonSubtraction?.setOnClickListener { onClickSymbol("-") }
        binding.buttonEquals.setOnClickListener { onClickEquals() }
        binding.rvHistoric?.layoutManager = LinearLayoutManager(this)
        binding.rvHistoric?.adapter = adapter
    }

    private fun onClickSymbol(symbols: String){
        Log.i(TAG, "Click ${symbols}")
        if (binding.textVisor.text == "0") {
            binding.textVisor.text = symbols
            exp += symbols
            } else {
                binding.textVisor.append(symbols)
                exp += symbols
            }
    }

    private fun onClickEquals(){
        Log.i(TAG, "Click equal")
        val expression = ExpressionBuilder(
            binding.textVisor.text.toString()
        ).build()
        binding.textVisor.text = expression.evaluate().toString()
        exp += "=${binding.textVisor.text.toString()}"
        operations.add(exp)
        adapter.updatedItems(operations)

        Log.i(TAG, "The result is ${binding.textVisor.text}")
        Log.i(TAG, "Expression: ${exp}")
        Log.i(TAG, "History: ${operations}")
    }

    private fun onOperationClick(operation: String) {
        Toast.makeText(this, operation, Toast.LENGTH_LONG).show()
    }

    private fun onLongClick(){

    }

    override fun onDestroy() {
        Log.i(TAG, "The method onDestroy was called!")
        super.onDestroy()
    }
}


