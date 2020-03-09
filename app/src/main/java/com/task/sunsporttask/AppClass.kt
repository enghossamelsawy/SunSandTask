package com.task.sunsporttask

import android.app.Application
import com.task.sunsporttask.base.di.start


class AppClass:Application() {

    override fun onCreate() {
        super.onCreate()
        start(this)
    }
}