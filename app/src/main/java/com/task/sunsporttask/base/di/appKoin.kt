package com.task.sunsporttask.base.di

import android.app.Application
import com.task.sunsporttask.base.remote.remoteModule
import com.task.sunsporttask.mainScreen.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun start(application: Application){

    startKoin {
        androidContext(application)
        printLogger()

        modules(
            listOf(
                remoteModule,
                mainModule
            ))
    }
}