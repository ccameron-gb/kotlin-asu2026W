package com.example.kotlin_demo_mobile_app

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isBlue = false

    data class AppInfo(
        val name: String,
        val version: String,
        val description: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.myButton)

        val appList = listOf(
            AppInfo("ColorChanger", "1.0", "Changes background color on button click"),
            AppInfo("ColorChanger", "1.2", "Metadata added from V1.0")
        )

        val filteredApps = appList.filter { it.version.startsWith("1") }
        val appNames = filteredApps.map { it.name }

        Log.d("AppInfoTest", appNames.toString())

        updateBackgroundAndButtonText(myButton)

        myButton.setVisible(true)

        myButton.onClicked {
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