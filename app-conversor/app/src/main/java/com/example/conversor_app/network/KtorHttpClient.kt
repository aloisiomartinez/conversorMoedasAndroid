package com.example.conversor_app.network

import com.example.conversor_app.network.model.CurrencyTypeResult
import com.example.conversor_app.network.model.ExchangeRateResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

object KtorHttpClient {

    private const val BASE_URL = "http://10.0.2.2:8080"

    val client = HttpClient(Android) {
        install(Logging)
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getExchangeRate(from: String, to: String): Result<ExchangeRateResult> {
        return requireGet(url = "$BASE_URL/exchange_rate/$from/$to")
    }

    suspend fun getCurrencyTypes(): Result<CurrencyTypeResult> {
        return requireGet(url = "$BASE_URL/currency_types")
    }

    private suspend inline fun <reified T> requireGet(url: String): Result<T> {
        return try {
            Result.success(client.get(url).body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}