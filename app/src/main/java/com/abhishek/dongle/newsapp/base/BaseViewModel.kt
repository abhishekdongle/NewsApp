package com.abhishek.dongle.newsapp.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

open class BaseViewModel : ViewModel() {

    val scope = CoroutineScope(Dispatchers.IO)

    fun clear() {
        scope.cancel()
    }
}
