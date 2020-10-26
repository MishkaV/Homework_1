package com.example.homework1

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.view.OrientationEventListener
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

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

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putStringArrayList("KEY", adapter.getDigits())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        numList = findViewById(R.id.recyclerView)
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            numList.layoutManager = GridLayoutManager(baseContext, 3, RecyclerView.VERTICAL, false)
        else
            numList.layoutManager = GridLayoutManager(baseContext, 4, RecyclerView.VERTICAL, false)
        savedInstanceState?.getStringArrayList("KEY")?.let { digitsList.setArray(it) }
        adapter = NumAdapter(digitsList)
        numList.adapter = adapter
    }

    fun addDigit(view: View) {
        adapter.addDigit()
    }
    fun check(view : View) {
        println("lol")
    }
}
