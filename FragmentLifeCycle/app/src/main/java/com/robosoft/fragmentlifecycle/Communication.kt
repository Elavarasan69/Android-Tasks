package com.robosoft.fragmentlifecycle


interface Communication {
    fun passName(editTextData: String)
    fun passID(editTextData: Int)
    fun passAuthority(editTextData: Boolean)
    fun passQuantity(editTextData: Int)
    fun passPrice(editTextData: Double)

}