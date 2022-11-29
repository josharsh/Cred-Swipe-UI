package com.cred.josharsh.credAnim.api


import com.cred.josharsh.credAnim.constants.BASE_URL
import io.ktor.client.request.*
import io.ktor.client.statement.*

class SwapAnimationApi : BaseApi() {
    suspend fun getSwipeResults(path: String): HttpResponse {
        return httpClient.get("$BASE_URL/$path")
    }
}