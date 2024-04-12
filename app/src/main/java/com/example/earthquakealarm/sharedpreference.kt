package com.example.earthquakealarm
import android.content.Context
import android.content.SharedPreferences

class sharedpreference (context: Context){

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveString (key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()

    }

    fun getString (key: String, defaultValue: String): String? {
        return sharedPreferences.getString(key, defaultValue)
    }
}