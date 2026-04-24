/**
 * MainActivity.kt
 *
 * A simple color toggle app. Clicking the button switches
 * the background color between red and blue.
 */

package com.example.kotlin_demo_mobile_app

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var isBlue = false
    private val config = Config()
    private val buttonAdapter = ComponentAdapter<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        config {
            theme = "dark"
            fontSize = 16
            primaryColor = "Red"
        }

        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.myButton)

        // Integrate ComponentAdapter with ColorUtils
        buttonAdapter.add(myButton) {
            val color = getColorHexOrDefault("Blue")
            setBackgroundColor(color)
        }

        // Initial setup
        updateBackgroundAndButtonText(myButton)

        myButton.setOnClickListener {
            isBlue = !isBlue
            updateBackgroundAndButtonText(myButton)
        }
    }

    private fun updateBackgroundAndButtonText(button: Button) {
        if (isBlue) {
            window.decorView.setBackgroundColor(Color.BLUE)
            button.text = "Click to change to Red"
        } else {
            window.decorView.setBackgroundColor(Color.RED)
            button.text = "Click to change to Blue"
        }
    }
}
