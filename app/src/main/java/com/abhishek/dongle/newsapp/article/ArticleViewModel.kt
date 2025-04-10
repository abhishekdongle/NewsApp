package com.abhishek.dongle.newsapp.article

import com.abhishek.dongle.newsapp.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticleViewModel : BaseViewModel() {

    private val _articleState = MutableStateFlow(ArticleState())
    val articleState: StateFlow<ArticleState> get() = _articleState

}
