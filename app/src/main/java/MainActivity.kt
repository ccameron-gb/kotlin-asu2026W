<<<<<<< HEAD
/**
 * MainActivity.kt
 *
 * A simple color toggle app. Clicking the button switches
 * the background color between red and blue.
 */

=======
>>>>>>> 53cb311 (feat:personalize greeting)
package com.example.kotlin_demo_mobile_app

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

<<<<<<< HEAD
=======
import android.widget.TextView


>>>>>>> 53cb311 (feat:personalize greeting)
class MainActivity : AppCompatActivity() {

    private var isBlue = false  // Track the background color

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.myButton)
<<<<<<< HEAD

        // Initial setup
        updateBackgroundAndButtonText(myButton)

=======
        //textview addition
        val textView: TextView = findViewById(R.id.textView)
        //set the string
        val myName = "Alejandro"
        textView.text = "Hello from $myName!"
        // Initial setup
        updateBackgroundAndButtonText(myButton)
>>>>>>> 53cb311 (feat:personalize greeting)
        myButton.setOnClickListener {
            // Toggle the isBlue flag
            isBlue = !isBlue
            updateBackgroundAndButtonText(myButton)
        }
    }
<<<<<<< HEAD

=======
>>>>>>> 53cb311 (feat:personalize greeting)
    private fun updateBackgroundAndButtonText(button: Button) {
        if (isBlue) {
            // If isBlue is true, set the background to blue and button text to "Click to change to Red"
            window.decorView.setBackgroundColor(Color.BLUE)
            button.text = "Click to change to Red"
        } else {
            // If isBlue is false, set the background to red and button text to "Click to change to Blue"
            window.decorView.setBackgroundColor(Color.RED)
            button.text = "Click to change to Blue"
        }
    }
}
