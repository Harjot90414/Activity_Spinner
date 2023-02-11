package com.harjot.activity_spinner

interface ClickInterface {
    fun editClick(position:Int)
    fun deleteClick(position:Int)

    fun addCounter(position: Int)
    fun removeCounter(position: Int)
}