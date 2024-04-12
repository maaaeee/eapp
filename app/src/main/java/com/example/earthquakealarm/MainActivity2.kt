package com.example.earthquakealarm

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentManager

class MainActivity2 : AppCompatActivity() {

    val fragmentTManager = supportFragmentManager
    private lateinit var sharedPreferences: sharedpreference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // Initialize sharedPreferences before using it
        sharedPreferences = sharedpreference(this)
        val editText = findViewById<EditText>(R.id.placeholder)

// Retrieve the phone number from SharedPreferences
        val savedPhoneNumber = sharedPreferences.getString("number", "")

// Set the retrieved phone number to the EditText
        editText.setText(savedPhoneNumber)


        if (findViewById<FrameLayout>(R.id.frame_layout)!= null){
            val fragmentTransaction = fragmentTManager.beginTransaction()
//            fragmentTransaction.add(R.id.frame_layout, History())
            fragmentTransaction.commit()

        }
    }

//    fun onClickHistory(item: MenuItem) {
//        val fragmentTransaction = fragmentTManager.beginTransaction()
//        fragmentTransaction.add(R.id.frame_layout, History())
//        fragmentTransaction.commit()
//    }

    fun onClickMessage(item: MenuItem) {
        val fragmentTransaction = fragmentTManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_layout, Message())
        fragmentTransaction.commit()}

    fun onClickInfo(item: MenuItem) {
        val fragmentTransaction = fragmentTManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_layout, Information())
        fragmentTransaction.commit()
    }

    fun onClickAbout(item: MenuItem) {
        val fragmentTransaction = fragmentTManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_layout, About())
        fragmentTransaction.commit()
    }
}