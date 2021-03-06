package com.example.homework1

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        const val spanCountVertical = 3
        const val spanCountHorizontal = 4
    }
    var digitsList: ListNumbers = ListNumbers()
    lateinit var adapter: NumAdapter
    lateinit var numList: RecyclerView
    lateinit var mainFrag: MainFragment
    var checkFragment: Int = 0
    var clickedNum: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainFrag = MainFragment()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_fragment, mainFrag, "main")
                .addToBackStack(null)
                .commit()
        }

        checkFragment = 0
        numList = findViewById(R.id.recyclerView)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            numList.layoutManager =
                GridLayoutManager(baseContext, spanCountVertical, RecyclerView.VERTICAL, false)
        else
            numList.layoutManager =
                GridLayoutManager(baseContext, spanCountHorizontal, RecyclerView.VERTICAL, false)
        if (savedInstanceState == null)
            digitsList.init()
        else
            savedInstanceState?.getStringArrayList("KEY")?.let { digitsList.setArray(it) }
        adapter = NumAdapter(digitsList)
        numList.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putStringArrayList("KEY", adapter.getDigits())
        }
        super.onSaveInstanceState(outState)
    }
    fun addDigit(view: View) {
        adapter.addDigit()
    }

    fun check(view: View) {
        checkFragment = 1
        val bigNum = BigNumFragment.newInstance(adapter.itemClick(numList, view))
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_fragment, bigNum, "bigNum")
            .addToBackStack(null)
            .commit()
    }

    fun back(view: View) {
        checkFragment = 0
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_fragment, mainFrag)
            .addToBackStack(null)
            .commit()
    }
}
