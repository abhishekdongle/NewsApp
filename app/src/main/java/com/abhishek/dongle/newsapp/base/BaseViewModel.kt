package com.abhishek.dongle.newsapp.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

open class BaseViewModel {

    val scope = CoroutineScope(Dispatchers.IO)

    fun clear() {
        scope.cancel()
    }
}
