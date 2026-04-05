package com.example.kotlin_demo_mobile_app

import android.view.View
import android.widget.Button

fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun Button.onClicked(action: () -> Unit) {
    setOnClickListener { action() }
}