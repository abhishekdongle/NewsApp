package com.abhishek.dongle.newsapp.di

import app.cash.sqldelight.db.SqlDriver
import com.abhishek.dongle.newsapp.db.DatabaseDriverFactory
import com.abhishek.dongle.newsapp.db.NewsAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).create() }
    single<NewsAppDatabase> { NewsAppDatabase(get()) }
}
