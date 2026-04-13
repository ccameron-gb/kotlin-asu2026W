/**
 * MainActivity.kt
 *
 * A simple color toggle app. Clicking the button switches
 * the background color between red and blue.
 */
package com.example.kotlin_demo_mobile_app
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var isBlue = false
    private val repositoryManager = RepositoryManager()

    data class AppInfo(
        override val id: String,
        val name: String,
        val version: String,
        val description: String
    ) : Identifiable

    data class basic_User(
        override val id: String,
        val username: String
    ) : Identifiable


    // Task 2/4
    private lateinit var myName: String
    private lateinit var textView: TextView

    ////Task 2/4
    private val greetingMessage: String
        get() {
            val hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
            val timeGreeting = when (hour) {
                in 0..11 -> "Good Morning"
                in 12..17 -> "Good Afternoon"
                else -> "Good Evening"
            }
            return "$timeGreeting, $myName!"
        }

    //Task 3/4
    data class User(val name: String, val id: String, val role: String) {
        override fun equals(other: Any?): Boolean{
            if(this === other) {
                return true
            }
            if(other !is User){
                return false
            }
            return name==other.name && id==other.id && role==other.role
        }
        override fun hashCode(): Int{
            var result = name.hashCode()
            result = 31 * result + id.hashCode()
            result = 31 * result + role.hashCode()
            return result
        }
        override fun toString(): String {
            return "User(name='$name', id='$id', role='$role')"
        }
    }
    //End of Task3/4

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

        val user = basic_User(
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
        val retrievedUser = repositoryManager.get<basic_User>("user1")

        Log.d("RepositoryTest", "Retrieved app: ${retrievedApp?.name}")
        Log.d("RepositoryTest", "Retrieved user: ${retrievedUser?.username}")

        // Task 1/4
        textView = findViewById(R.id.textView)
        myName = "Alejandro"
        textView.text = greetingMessage

        //Task 3/4 setup
        val originalUser = User("Alejandro", "001", "Intern")
        val newUser = originalUser.copy(role = "Knowledge Manager")
        println("Original User: $originalUser")
        println("New User: $newUser")

        // Initial setup
        updateBackgroundAndButtonText(myButton)

        myButton.setOnClickListener {
            isBlue = !isBlue
            updateBackgroundAndButtonText(myButton)

            //updates time greeting dynamically, Task 2/4
            textView.text = greetingMessage
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