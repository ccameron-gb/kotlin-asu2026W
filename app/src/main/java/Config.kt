/**
 * Config.kt
 *
 * Demonstrates Kotlin's invoke convention for DSL-style initialization.
 */

package com.example.kotlin_demo_mobile_app

class Config {
    var theme: String = "light"
    var fontSize: Int = 14
    var primaryColor: String = "Blue"

    operator fun invoke(block: Config.() -> Unit) {
        this.block()
    }
}