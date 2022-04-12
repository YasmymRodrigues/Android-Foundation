package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat


class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    private lateinit var viewModel: CalculatorViewModel
    private val operations = mutableListOf<OperationUi>();
    private val adapter = HistoryAdapter(::onOperationClick, ::onLongClick)
    var someDate: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(
            R.layout.fragment_calculator, container, false
        )
        binding = FragmentCalculatorBinding.bind(view)
        viewModel = ViewModelProvider(this).get(
            CalculatorViewModel::class.java
        )
        binding.textVisor.text = viewModel.getDisplayValue()
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        binding.button0.setOnClickListener { onClickSymbol("0") }
        //binding.button00?.setOnClickListener { onClickSymbol("00") }
        binding.button1.setOnClickListener { onClickSymbol("1") }
        binding.button2.setOnClickListener { onClickSymbol("2") }
        binding.button3.setOnClickListener { onClickSymbol("3") }
        binding.button4.setOnClickListener { onClickSymbol("4") }
        binding.button5.setOnClickListener { onClickSymbol("5") }
        binding.button6.setOnClickListener { onClickSymbol("6") }
        //binding.button7?.setOnClickListener { onClickSymbol("7") }
        //binding.button8?.setOnClickListener { onClickSymbol("8") }
        //binding.button9?.setOnClickListener { onClickSymbol("9") }
        binding.buttonAdditon.setOnClickListener { onClickSymbol("+") }
        //binding.buttonSubtraction?.setOnClickListener { onClickSymbol("-") }
        binding.buttonEquals.setOnClickListener {
            binding.textVisor.text = viewModel.onClickEquals() }
        //binding.rvHistoric?.layoutManager = LinearLayoutManager(this)
        //binding.rvHistoric?.adapter = adapter
    }

    private fun onClickSymbol(symbols: String){

        if (binding.textVisor.text == "0") {
            binding.textVisor.text = symbols
            //exp += symbols
        } else {
            binding.textVisor.append(symbols)
            //exp += symbols
        }
    }

    private fun onClickEquals(){

        val expression = ExpressionBuilder(
            binding.textVisor.text.toString()
        ).build()
        binding.textVisor.text = expression.evaluate().toString()
        //operations.add(binding.textVisor.text.toString())
        adapter.updatedItems(operations)
        val operationUi = OperationUi(expression = "", result = "${binding.textVisor.text}", timeStamp = 11)
        operations.add(operationUi)

    }

    private fun onOperationClick(operation: String) {
        //Toast.makeText(this, operation, Toast.LENGTH_LONG).show()
    }

    private fun onLongClick(someDate: Long){
        //Toast.makeText(this, someDate.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {

        super.onDestroy()
    }
}