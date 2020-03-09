package com.task.sunsporttask.mainScreen.di

import com.task.sunsporttask.mainScreen.presentation.MainViewModel
import com.task.sunsporttask.mainScreen.data.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val mainModule = module {

    factory { get<Retrofit>().create(UserService::class.java) }
    factory<IMainDataSource> { MainDataSource(get()) }
    factory<IMainRepository> { MainRepository(get()) }
    viewModel { MainViewModel(get()) }

}