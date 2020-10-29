package com.example.homework1

class ListNumbers {
    companion object {
        const val rangeEnd = 100
    }
    private var numbers: ArrayList<String> = ArrayList()

    fun init() {
        for (i in 1..rangeEnd)
            this.numbers.add("$i")
    }
    fun setArray(array: ArrayList<String>) {
        numbers = array
    }
    fun addNum() {
        this.numbers.add((this.numbers.last().toInt() + 1).toString())
    }

    fun getList(): ArrayList<String> {
        return this.numbers
    }
}
