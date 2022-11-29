package com.cred.josharsh.credAnim.remoteDataSources

import com.cred.josharsh.credAnim.api.SwapAnimationApi
import com.cred.josharsh.credAnim.mapper.SwipeAnimationApiResponseMapper
import com.cred.josharsh.credAnim.models.SwipeResult
import io.ktor.client.call.*

class SwipeAnimationRemoteDataSource {
    suspend fun getSwipeResults(path: String): SwipeResult {
        return try {
            val httpResponse = SwapAnimationApi().getSwipeResults(path)
            if (httpResponse.status.value in 200..299) {
                val swipeResult = SwipeAnimationApiResponseMapper().mapFrom(httpResponse.body())
                if (swipeResult.error != null) {
                    SwipeResult(error = swipeResult.error)
                } else swipeResult
            } else {
                SwipeResult(error = "Api failed with status code ${httpResponse.status.value}")
            }
        } catch (exception: Exception) {
            SwipeResult(error = "Api failed with exception ${exception.message}")
        }
    }
}