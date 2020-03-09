package com.task.sunsporttask.base.remote


import com.google.gson.GsonBuilder
import com.task.sunsporttask.BuildConfig

import com.task.sunsporttask.base.data.RemoteConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val remoteModule = module {
    single { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }

    single {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(RemoteConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(RemoteConstants.READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(RemoteConstants.WRITE_TIMEOUT, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(get<HttpLoggingInterceptor>())
        }
        builder.build()
    }

    single { GsonBuilder().create() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }


}