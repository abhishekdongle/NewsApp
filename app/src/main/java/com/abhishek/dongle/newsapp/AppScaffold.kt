package com.abhishek.dongle.newsapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhishek.dongle.newsapp.article.ArticlesViewModel
import com.abhishek.dongle.newsapp.screens.ArticlesScreen
import com.abhishek.dongle.newsapp.screens.Screens
import com.abhishek.dongle.newsapp.screens.SettingsScreen

@Composable
fun AppScaffold(articlesViewModel: ArticlesViewModel) {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            articleViewModel = articlesViewModel
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier,
    articleViewModel: ArticlesViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                articleViewModel = articleViewModel,
                onSettingsClicked = { navController.navigate(Screens.SETTINGS.route) })
        }
        composable(Screens.SETTINGS.route) {
            SettingsScreen()
        }
    }
}
