package com.example.kotlin_demo_mobile_app

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.IntRange

class ColorBuilder {

    @IntRange(from = 0, to = 255) private var red: Int = 0
    @IntRange(from = 0, to = 255) private var green: Int = 0
    @IntRange(from = 0, to = 255) private var blue: Int = 0

    fun rgb(
        r: Int = red,
        g: Int = green,
        b: Int = blue,
    ): ColorBuilder {
        red   = r.coerceIn(0, 255)
        green = g.coerceIn(0, 255)
        blue  = b.coerceIn(0, 255)
        return this
    }

    fun toHex(): String =
        String.format("#%02X%02X%02X", red, green, blue)

    fun toColorInt(): Int =
        android.graphics.Color.rgb(red, green, blue)

    @RequiresApi(Build.VERSION_CODES.O)
    fun toColor(): Color =
        Color.valueOf(red / 255f, green / 255f, blue / 255f)

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun fromColor(color: Color): ColorBuilder =
            ColorBuilder().rgb(
                r = (color.red()   * 255).toInt(),
                g = (color.green() * 255).toInt(),
                b = (color.blue()  * 255).toInt()
            )
    }
}