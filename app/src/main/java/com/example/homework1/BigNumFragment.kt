package com.example.homework1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

private const val ARG_PARAM1 = "param1"

class BigNumFragment : Fragment() {

    private var number: String? = "Hello world"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            number = it.getString(ARG_PARAM1)
        }
        this.retainInstance = true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("tag", number)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_big_num, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numInt: Int = Integer.parseInt(number)
        val textNum = view.findViewById<TextView>(R.id.textViewNum)
        textNum.text = number
        if (numInt % 2 == 0)
            view.findViewById<TextView>(R.id.textViewNum)
                .setTextColor(ContextCompat.getColor(textNum.context, R.color.odd))
        else
            view.findViewById<TextView>(R.id.textViewNum)
                .setTextColor(ContextCompat.getColor(textNum.context, R.color.even))
    }

    companion object {
        @JvmStatic
        fun newInstance(number: String) =
            BigNumFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, number)
                }
            }
    }
}
