package com.poc.utility

sealed class ServiceStates<T>(
    var data: T? = null,
    var error: Throwable? = null
) {
    class Success<T>(data: T) : ServiceStates<T>(data)
    class Loading<T>(data: T? = null) : ServiceStates<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : ServiceStates<T>(data, throwable)
}