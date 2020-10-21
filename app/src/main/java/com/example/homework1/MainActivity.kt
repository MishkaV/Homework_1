package com.example.homework1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.size
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.digits.view.*


class MainActivity : AppCompatActivity() {

    var digitsList : ListNumbers = ListNumbers()
    var adapter: NumAdapter = NumAdapter(digitsList)
    lateinit var  numList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numList =  findViewById(R.id.recyclerView)
        numList.layoutManager = GridLayoutManager(baseContext, 3, RecyclerView.VERTICAL, false)
        digitsList.init()
        numList.adapter = adapter

     }

   fun addDigit(view: View)
   {
        adapter.addDigit()
   }
}
