package com.axel.cryptocurrency.presentation.coin_list

import com.axel.cryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error : String = ""
)