package com.abhishek.dongle.newsapp.article

import android.util.Log
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

    private var httpClient: HttpClient
    private var articlesService: ArticlesService

    init {
        httpClient = getHttpClient()
        articlesService = ArticlesService(httpClient)
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = articlesService.fetchArticles()
            delay(1000)
            _articleState.emit(ArticlesState(error = "Something went wrong."))
            Log.d("test: ", "list = ${fetchedArticles.size}")
//            _articleState.emit(ArticlesState(articles = fetchedArticles))
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
