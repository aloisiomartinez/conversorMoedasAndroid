package com.aloisio.model

fun String.orUnknown() : String =
    if (this in exchangeRates.keys) this else "Desconhecido"

fun Double?.orZero() : Double =  this ?: 0.0