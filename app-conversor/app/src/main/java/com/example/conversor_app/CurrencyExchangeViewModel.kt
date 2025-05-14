package com.example.conversor_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conversor_app.network.KtorHttpClient
import com.example.conversor_app.network.model.CurrencyType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CurrencyExchangeViewModel: ViewModel() {

    private val _currencyTypes = MutableStateFlow<Result<List<CurrencyType>>>(Result.success(emptyList()))
    val currencyTypes: StateFlow<Result<List<CurrencyType>>> = _currencyTypes.asStateFlow()

    init {
        //Thread do próprio ViewModel para não usar a Thread Principal do ANDROID ao realizar chamadas assincrónas
        viewModelScope.launch {
            _currencyTypes.value = KtorHttpClient.getCurrencyTypes().mapCatching { result ->
                result.values
            }
        }
    }
}