/**
 * ColorUtils.kt
 *
 * Demonstrates Kotlin Map usage, null safety, and defensive coding
 * with getOrElse() fallback values.
 */

package com.example.kotlin_demo_mobile_app

// Map of color names to ARGB hex values (matches Android's Color int format)
val colorMap: Map<String, Int> = mapOf(
    "Red"     to 0xFFFF0000.toInt(),
    "Green"   to 0xFF00FF00.toInt(),
    "Blue"    to 0xFF0000FF.toInt(),
    "Yellow"  to 0xFFFFFF00.toInt(),
    "Cyan"    to 0xFF00FFFF.toInt(),
    "Magenta" to 0xFFFF00FF.toInt(),
    "White"   to 0xFFFFFFFF.toInt(),
    "Black"   to 0xFF000000.toInt()
)

/**
 * Looks up a color by name using find() on the map entries.
 * Returns the hex Int value, or null if the color isn't in the map.
 */
fun getColorHex(name: String): Int? =
    colorMap.entries.find { it.key == name }?.value

/**
 * Returns the hex value for [name], falling back to gray (0xFF808080)
 * via getOrElse() so callers never receive null.
 */
fun getColorHexOrDefault(name: String): Int =
    colorMap.getOrElse(name) { 0xFF808080.toInt() }
