package com.ozalp.crypto.service

import com.ozalp.crypto.api.CryptoAPI
import com.ozalp.crypto.model.Crypto
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CryptoAPIService {
    private val BASE_URL = "https://raw.githubusercontent.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // rxjava ile
        .build()
        .create(CryptoAPI::class.java)

    fun getData(): Observable<List<Crypto>> {
        return retrofit.getData()
    }
}