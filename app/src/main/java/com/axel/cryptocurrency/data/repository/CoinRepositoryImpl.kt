package com.axel.cryptocurrency.data.repository

import com.axel.cryptocurrency.data.remote.CoinPaprikaApi
import com.axel.cryptocurrency.data.remote.dto.CoinDetailDto
import com.axel.cryptocurrency.data.remote.dto.CoinDto
import com.axel.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}