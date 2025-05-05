package com.abhishek.dongle.newsapp.article.di

import com.abhishek.dongle.newsapp.article.ArticlesDataSource
import com.abhishek.dongle.newsapp.article.ArticlesRepository
import com.abhishek.dongle.newsapp.article.ArticlesService
import com.abhishek.dongle.newsapp.article.ArticlesUseCase
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
}
