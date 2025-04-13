package com.abhishek.dongle.newsapp.di

import com.abhishek.dongle.newsapp.article.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { ArticlesViewModel(get()) }
}
