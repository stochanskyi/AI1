package com.mars.ai1.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> withIOContext(block: suspend CoroutineScope.() -> T): T {
    return withContext(Dispatchers.IO, block)
}

