package com.example.kotlin_demo_mobile_app

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isBlue = false
    private val repositoryManager = RepositoryManager()

    data class AppInfo(
        override val id: String,
        val name: String,
        val version: String,
        val description: String
    ) : Identifiable

    data class User(
        override val id: String,
        val username: String
    ) : Identifiable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.myButton)

        val appList = listOf(
            AppInfo(
                id = "app1",
                name = "ColorChanger",
                version = "1.0",
                description = "Changes background color on button click"
            ),
            AppInfo(
                id = "app2",
                name = "ColorChanger",
                version = "1.2",
                description = "Metadata added from V1.0"
            )
        )

        appList.forEach { repositoryManager.save(it) }

        val user = User(
            id = "user1",
            username = "student_user"
        )
        repositoryManager.save(user)

        val filteredApps = repositoryManager
            .repository<AppInfo>()
            .getAll()
            .filter { it.version.startsWith("1") }

        val appNames = filteredApps.map { it.name }
        Log.d("AppInfoTest", appNames.toString())

        val retrievedApp = repositoryManager.get<AppInfo>("app1")
        val retrievedUser = repositoryManager.get<User>("user1")

        Log.d("RepositoryTest", "Retrieved app: ${retrievedApp?.name}")
        Log.d("RepositoryTest", "Retrieved user: ${retrievedUser?.username}")

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