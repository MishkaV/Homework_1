package com.example.homework1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var digitsList: ListNumbers = ListNumbers()
    var adapter: NumAdapter = NumAdapter(digitsList)
    lateinit var numList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numList = findViewById(R.id.recyclerView)
        numList.layoutManager = GridLayoutManager(baseContext, 3, RecyclerView.VERTICAL, false)
        digitsList.init()
        numList.adapter = adapter
    }
    fun addDigit(view: View) {
        adapter.addDigit()
    }
}
