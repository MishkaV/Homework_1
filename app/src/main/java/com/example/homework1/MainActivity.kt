package com.example.homework1

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var digitsList: ListNumbers = ListNumbers()
    var adapter: NumAdapter = NumAdapter(digitsList)
    lateinit var numList: RecyclerView
    val mainFrag = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, mainFrag)
            addToBackStack(null)
            commit()
        }


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
        val bigNum = BigNumFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, bigNum)
            addToBackStack(null)
            commit()
        }
    }
}
