package com.example.homework1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class NumAdapter(private val numbers: ListNumbers) : RecyclerView.Adapter<NumAdapter.NumHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumHolder {
        val itemHolder = LayoutInflater.from(parent?.context).inflate(R.layout.number_recycler_view, parent, false)
        return NumHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: NumHolder, position: Int) {
        holder.number.text = numbers.getList()[position]
        if (position % 2 == 0) {
            holder.number.setTextColor(ContextCompat.getColor(holder.number.context, R.color.even))
        } else {
            holder.number.setTextColor(ContextCompat.getColor(holder.number.context, R.color.odd))
        }
    }

    fun addDigit() {
        numbers.addNum()
        notifyItemInserted(numbers.getList().size - 1)
    }

    fun getDigits(): ArrayList<String> {
        return numbers.getList()
    }

    override fun getItemCount(): Int {
        return numbers.getList().size
    }

    fun itemClick(recyclerView: RecyclerView, view: View): String {
        val itemPos: Int = recyclerView.getChildLayoutPosition(view)
        return numbers.getList()[itemPos]
    }

    class NumHolder(view: View) : RecyclerView.ViewHolder(view) {
        var number = itemView.findViewById<TextView>(R.id.numberFragment)
    }
}
