package com.danyglaz.yaduvankinapp.util

import android.os.Message

sealed interface Result {
    data class Success<T>(val message: String = "", val data: T? = null): Result
    data class Failure<T>(val message: String = "", val data: T? = null): Result
}