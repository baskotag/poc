package com.poc.utility

sealed class ServiceStates<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : ServiceStates<T>(data)
    class Loading<T>(data: T? = null) : ServiceStates<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : ServiceStates<T>(data, throwable)
}