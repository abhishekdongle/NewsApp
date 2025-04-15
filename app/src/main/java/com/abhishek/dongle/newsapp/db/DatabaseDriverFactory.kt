package com.abhishek.dongle.newsapp.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

class DatabaseDriverFactory(private val context: Context) {

    fun create(): SqlDriver {
        return AndroidSqliteDriver(
            schema = NewsAppDatabase.Schema,
            context = context,
            name = "newsapp.db"
        )
    }
}
