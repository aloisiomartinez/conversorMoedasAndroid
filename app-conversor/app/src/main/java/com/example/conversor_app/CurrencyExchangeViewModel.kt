package com.example.conversor_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conversor_app.network.KtorHttpClient
import com.example.conversor_app.network.model.CurrencyType
import com.example.conversor_app.network.model.ExchangeRateResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CurrencyExchangeViewModel: ViewModel() {

    private val _currencyTypes = MutableStateFlow<Result<List<CurrencyType>>>(Result.success(emptyList()))
    val currencyTypes: StateFlow<Result<List<CurrencyType>>> = _currencyTypes.asStateFlow()

    private val _exchangeRate = MutableStateFlow<Result<ExchangeRateResult?>>(Result.success(null))
    val exchangeRate: StateFlow<Result<ExchangeRateResult?>> = _exchangeRate.asStateFlow()

    init {
        //Thread do próprio ViewModel para não usar a Thread Principal do ANDROID ao realizar chamadas assincrónas
        viewModelScope.launch {
            _currencyTypes.value = KtorHttpClient.getCurrencyTypes().mapCatching { result ->
                result.values
            }

            _exchangeRate.value = KtorHttpClient.getExchangeRate(from = "BRL", to = "USD")
        }
    }
}