package com.poc.utility

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> taskOperator(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(ServiceStates.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { ServiceStates.Success(it) }
        } catch (throwable: Throwable) {
            query().map { ServiceStates.Error(throwable, it) }
        }
    } else {
        query().map { ServiceStates.Success(it) }
    }
    emitAll(flow)
}
