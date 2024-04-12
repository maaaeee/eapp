package com.example.earthquakealarm

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentManager
import com.example.earthquakealarm.databinding.ActivityMain2Binding
import com.example.earthquakealarm.databinding.ActivityMainBinding
import com.example.earthquakealarm.ui.theme.EarthquakeAlarmTheme
import android.content.Context
import android.content.SharedPreferences



class MainActivity : ComponentActivity() {

  private lateinit var sharedPreferences: sharedpreference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = sharedpreference(this)

//        val sharedpreference = sharedpreference(context)


        val btn = findViewById<Button>(R.id.registerButton)
//        val e = findViewById<EditText>(R.id.PhoneNumberEditText)
        val rcm = findViewById<Button>(R.id.enterButton)
        val context = this
        val editText = findViewById<EditText>(R.id.PhoneNumberEditText)
        btn?.setOnClickListener {
            try {
                if (editText.length() == 0) {
                    Toast.makeText(applicationContext, "Number cannot be empty", Toast.LENGTH_SHORT)
                        .show()
                } else if (editText.length() > 11 || editText.length() < 11) {
                    Toast.makeText(
                        applicationContext,
                        "cellphone number shouldn't be greater or less than 11",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val phoneNumberText = editText.text.toString()
// Convert the text to an integer
                    sharedPreferences.saveString("number", phoneNumberText)
// Now you have the phone number as an integer in the phoneNumber variable
                    // Use default value if conversion fails
//                    var number = register(phoneNumber);
//                    var db = databasehandler(context)
//                    db.insertData(number)
                    Toast.makeText(applicationContext, "Successfully inserted data", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MainActivity, MainActivity2::class.java))
//                    startActivity(Intent(this@MainActivity, MainActivity2::class.java))
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error starting MainActivity2: ${e.message}")
            }
        }

        rcm.setOnClickListener {
            try {
                if (editText.length() == 0) {
                    Toast.makeText(
                        applicationContext,
                        "Please enter your number",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else if (editText.length() > 11 || editText.length() < 11) {
                    Toast.makeText(
                        applicationContext,
                        "cellphone number shouldn't be greater or less than 11",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    startActivity(Intent(this@MainActivity, MainActivity2::class.java))
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error starting MainActivity2: ${e.message}")
            }
        }
    }
}