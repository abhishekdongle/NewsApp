package com.abhishek.dongle.newsapp.article

import com.abhishek.dongle.newsapp.db.NewsAppDatabase

class ArticlesDataSource(private val database: NewsAppDatabase) {

    fun getAllArticles(): List<ArticleRaw> {
        return database.newsAppDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()
    }

    fun insertArticles(articles: List<ArticleRaw>) {
        database.newsAppDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    private fun insertArticle(article: ArticleRaw) {
        database.newsAppDatabaseQueries.insertArticle(
            article.title,
            article.desc,
            article.date,
            article.imageUrl
        )
    }

    fun clearArticles() = database.newsAppDatabaseQueries.removeAllArticles()

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw {
        return ArticleRaw(
            title,
            desc,
            date,
            imageUrl
        )
    }
}
