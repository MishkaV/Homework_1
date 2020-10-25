package com.example.homework1

class ListNumbers {
    private var numbers: ArrayList<String> = ArrayList()

    fun init() {
        for (i in 1..100)
            this.numbers.add("$i")
    }
    fun addNum() {
        this.numbers.add((this.numbers.last().toInt() + 1).toString())
    }

    fun getList(): ArrayList<String> {
        return this.numbers
    }
}
