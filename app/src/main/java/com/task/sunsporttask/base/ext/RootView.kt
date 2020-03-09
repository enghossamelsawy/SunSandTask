package com.task.sunsporttask.base.ext

import android.view.View
import com.google.android.material.snackbar.Snackbar
import android.widget.TextView
import com.task.sunsporttask.R

fun View.showSnakeBar(message: String, showDismiss: Boolean = false) {
    val duration = if (showDismiss) {
        Snackbar.LENGTH_INDEFINITE
    } else {
        Snackbar.LENGTH_LONG
    }
    val snakeBar = Snackbar.make(this, message, duration)
    if (showDismiss) {
        snakeBar.setAction(context.getString(R.string.dismiss)) {
            snakeBar.dismiss()
        }
    }
    val textView =
        snakeBar.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    textView.maxLines = 4
    snakeBar.show()
}

