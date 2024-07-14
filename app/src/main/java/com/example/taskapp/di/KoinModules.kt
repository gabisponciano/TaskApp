package com.example.taskapp.di

import androidx.room.Room
import com.example.taskapp.db.TaskDatabase
import com.example.taskapp.repository.TaskRepository
import com.example.taskapp.ui.ui.Layout.viewmodel.HomeViewModel

import com.example.taskapp.ui.ui.Layout.viewmodel.TaskViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf

import org.koin.dsl.module

val appModule = module {
    viewModelOf(::TaskViewModel)
    viewModelOf (::HomeViewModel)

}

val storageModule = module {
    singleOf(::TaskRepository)
    single {
        Room.databaseBuilder(
            androidContext(),
            TaskDatabase::class.java, "task-database.db"
        ).build()
    }
    single {
        get<TaskDatabase>().TaskDao()
    }
}