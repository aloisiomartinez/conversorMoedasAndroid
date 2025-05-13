package com.aloisio.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRateResult(
    val from: String,
    val to: String,
    @SerialName("exchange_rate")
    val exchangeRate: Double
)

val exchangeRates: Map<String, Map<String, Double>> = mapOf(
    "USD" to mapOf(
        "EUR" to 0.94,
        "JPY" to 149.10,
        "GBP" to 0.82,
        "CNY" to 7.30,
        "BRL" to 5.10
    ),
    "EUR" to mapOf(
        "USD" to 1.06,
        "JPY" to 158.40,
        "GBP" to 0.87,
        "CNY" to 7.76,
        "BRL" to 5.41
    ),
    "JPY" to mapOf(
        "USD" to 0.0067,
        "EUR" to 0.0063,
        "GBP" to 0.0055,
        "CNY" to 0.049,
        "BRL" to 0.034
    ),
    "GBP" to mapOf(
        "USD" to 1.22,
        "EUR" to 1.15,
        "JPY" to 180.80,
        "CNY" to 8.90,
        "BRL" to 6.23
    ),
    "CNY" to mapOf(
        "USD" to 0.14,
        "EUR" to 0.13,
        "JPY" to 20.45,
        "GBP" to 0.11,
        "BRL" to 0.70
    ),
    "BRL" to mapOf(
        "USD" to 0.20,
        "EUR" to 0.18,
        "JPY" to 29.20,
        "GBP" to 0.16,
        "CNY" to 1.43
    )
)