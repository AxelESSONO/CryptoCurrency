package com.axel.cryptocurrency.domain.repository

import com.axel.cryptocurrency.data.remote.dto.CoinDetailDto
import com.axel.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() :  List<CoinDto>

    suspend fun getCoin(coinId : String) : CoinDetailDto

}