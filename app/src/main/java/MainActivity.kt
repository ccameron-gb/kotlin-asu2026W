/**
 * MainActivity.kt
 *
 * A simple color toggle app. Clicking the button switches
 * the background color between red and blue.
 */

package com.example.kotlin_demo_mobile_app

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private var isBlue = false  // Track the background color

    @SuppressLint("NewApi")
    private val blue  = ColorBuilder().rgb(0, 0, 212).toColor()
    @SuppressLint("NewApi")
    private val red = ColorBuilder().rgb(232, 0, 0).toColor()
    @SuppressLint("NewApi")
    private val green = ColorBuilder().rgb(0, 220, 0).toColor()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.myButton)

        // Initial setup
        updateBackgroundAndButtonText(myButton)

        myButton.setOnClickListener {
            // Toggle the isBlue flag
            isBlue = !isBlue
            val mixed = (blue + red).toArgb()
            window.decorView.setBackgroundColor(mixed)
            //updateBackgroundAndButtonText(myButton)  // original
        }
    }

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

    @RequiresApi(Build.VERSION_CODES.O)
    operator fun Color.plus(other: Color): Color {
        val r = ((red()   + other.red())   / 2f).coerceIn(0f, 1f)
        val g = ((green() + other.green()) / 2f).coerceIn(0f, 1f)
        val b = ((blue()  + other.blue())  / 2f).coerceIn(0f, 1f)
        val a = ((alpha() + other.alpha()) / 2f).coerceIn(0f, 1f)
        return Color.valueOf(r, g, b, a)
    }
}
