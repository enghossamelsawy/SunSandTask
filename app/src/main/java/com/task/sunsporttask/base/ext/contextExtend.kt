package com.task.sunsporttask.base.ext

import android.app.Dialog
import android.content.Context
import android.view.KeyEvent
import android.view.Window
import android.widget.Button
import com.task.sunsporttask.R


fun Context.showNetworkErrorDialog(onRetryClick: () -> Unit, onRetryBackClick: () -> Unit) {
    val dialog = Dialog(this, R.style.FullscreenTheme)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.layout_connection_error)
    dialog.findViewById<Button>(R.id.btnConnectionErrorRetry).setOnClickListener {
        dialog.cancel()
        onRetryClick()
    }
    dialog.setOnKeyListener { _, keyCode, _ ->
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onRetryBackClick()
        }
        false
    }
    dialog.show()
}
