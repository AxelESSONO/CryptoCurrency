package com.axel.cryptocurrency.domain.use_case.get_coin

import com.axel.cryptocurrency.common.Resource
import com.axel.cryptocurrency.data.remote.dto.toCoinDetail
import com.axel.cryptocurrency.domain.model.CoinDetail
import com.axel.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoin(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An Unexpected Error Occurred"))
        }catch (e : IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

}