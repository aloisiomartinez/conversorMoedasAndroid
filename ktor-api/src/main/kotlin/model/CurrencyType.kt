package com.aloisio.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyType(
    val name: String,
    val acronym: String,
    val symbol: String,
    @SerialName("country_flag_image_url")
    val countryFlagImageUrl: String
)

@Serializable
data class CurrencyTypeResult(
    val values: List<CurrencyType>
)

val currencyTypes = listOf(
    CurrencyType(
        acronym = "USD",
        name = "Dólar Americano",
        symbol = "$",
        countryFlagImageUrl = "https://flagcdn.com/us.svg"
    ),      // USA
    CurrencyType(
        acronym = "EUR",
        name = "Euro",
        symbol = "€",
        countryFlagImageUrl = "https://flagcdn.com/eu.svg"
    ),                 // European Union
    CurrencyType(
        acronym = "JPY",
        name = "Iene Japonês",
        symbol = "¥",
        countryFlagImageUrl = "https://flagcdn.com/jp.svg"
    ),         // Japan
    CurrencyType(
        acronym = "GBP",
        name = "Libra Esterlina",
        symbol = "£",
        countryFlagImageUrl = "https://flagcdn.com/gb.svg"
    ),      // United Kingdom
    CurrencyType(
        acronym = "CNY",
        name = "Yuan Chinês",
        symbol = "¥",
        countryFlagImageUrl = "https://flagcdn.com/cn.svg"
    ),          // China
    CurrencyType(
        acronym = "BRL",
        name = "Real Brasileiro",
        symbol = "R$",
        countryFlagImageUrl = "https://flagcdn.com/br.svg"
    ),     // Brazil
)