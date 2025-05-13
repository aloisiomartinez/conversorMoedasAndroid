package com.aloisio

import com.aloisio.model.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        // tipos de moedas (nome, acronimo, simbolo, imagem da bandeira do país)
        get("/currency_types") {
            call.respond(
                CurrencyTypeResult(
                    values = currencyTypes
                )
            )
        }

        //conversão de valores, moeda atual => moeda alvo, taxa de conversão entre essas moedas
        // from e to serão os acrônimos de cada moeda
        get("/exchange_rate/{from}/{to}") {
            val from = call.parameters["from"]?.uppercase() ?: return@get call.respondText(
                text = "Não foi possível obter o acrônimo da moeda atual.",
                status = HttpStatusCode.BadRequest
            )

            val to = call.parameters["to"]?.uppercase() ?: return@get call.respondText(
                text = "Não foi possível obter o acrônimo da moeda alvo.",
                status = HttpStatusCode.BadRequest
            )

            call.respond(
                ExchangeRateResult(
                    from = from.orUnknown(),
                    to = to.orUnknown(),
                    exchangeRate = exchangeRates[from]?.get(to).orZero()
                )
            )
        }
    }
}
