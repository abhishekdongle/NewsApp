package com.abhishek.dongle.newsapp.article

import com.abhishek.dongle.newsapp.base.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel : BaseViewModel() {

    private val _articleState = MutableStateFlow(ArticlesState(loading = true))
    val articleState: StateFlow<ArticlesState> get() = _articleState

    private var articlesUseCase: ArticlesUseCase

    init {
        val httpClient = getHttpClient()
        val articlesService = ArticlesService(httpClient)
        articlesUseCase = ArticlesUseCase(articlesService)
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = articlesUseCase.getArticles()
            delay(1000)
            _articleState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    private fun getHttpClient(): HttpClient {
        val client = HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
        return client
    }
}
