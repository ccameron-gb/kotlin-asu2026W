/**
 * ComponentAdapter.kt
 *
 * A generic adapter for managing UI components.
 * Demonstrates generic classes with type bounds and variance.
 *
 * Usage:
 *   val adapter = ComponentAdapter<Button>()
 *   adapter.add(myButton) {
 *       text = "Click me"
 *       isEnabled = true
 *   }
 */

package com.example.kotlin_demo_mobile_app

import android.view.View

// out T means this adapter only produces T, never consumes it
// This allows ComponentAdapter<Button> to be used where
// ComponentAdapter<View> is expected
class ComponentAdapter<out T : View>(
    private val components: MutableList<@UnsafeVariance T> = mutableListOf()
) {
    /**
     * Adds a component and applies a configuration lambda to it.
     * The lambda receiver is T, so properties can be set directly.
     */
    fun add(component: @UnsafeVariance T, config: T.() -> Unit) {
        component.config()
        components.add(component)
    }

    fun getAll(): List<T> = components
}