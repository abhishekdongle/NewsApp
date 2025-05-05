package com.abhishek.dongle.newsapp.di

import com.abhishek.dongle.newsapp.article.di.articlesModule

val sharedKoinModules = listOf(
    networkModule,
    articlesModule
)
