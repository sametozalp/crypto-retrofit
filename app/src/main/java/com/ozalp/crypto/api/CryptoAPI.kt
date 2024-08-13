package com.ozalp.crypto.api

import com.ozalp.crypto.model.Crypto
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): Observable<List<Crypto>>

}