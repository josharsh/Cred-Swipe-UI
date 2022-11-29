package com.cred.josharsh.credAnim.api

import io.ktor.client.*
import io.ktor.client.plugins.*

open class BaseApi {
    val httpClient = HttpClient {
        install(HttpTimeout) {
            socketTimeoutMillis = 30000
            requestTimeoutMillis = 30000
            connectTimeoutMillis = 30000
        }
    }
}