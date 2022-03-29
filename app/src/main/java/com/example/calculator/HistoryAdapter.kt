package com.example.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.databinding.ItemExpressionBinding



class HistoryAdapter(private val onOperationClick: (String) -> Unit, private val onOperationLongClick: (Long) -> Unit, private var items: List<OperationUi> = listOf()) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
        class HistoryViewHolder(val binding: ItemExpressionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemExpressionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onOperationClick(items[position].expression)
            onOperationClick(items[position].result)
        }
        holder.itemView.setOnLongClickListener{
            onOperationLongClick(items[position].timeStamp)
            true
        }



        val parts = items[position].expression
        holder.binding.textExpression.text = parts?.get(0).toString()
        holder.binding.textResult.text = parts?.get(1).toString()
    }

    override fun getItemCount() = items.size

    fun updatedItems(items: List<OperationUi>) {
        this.items = items
        notifyDataSetChanged()
    }

}
