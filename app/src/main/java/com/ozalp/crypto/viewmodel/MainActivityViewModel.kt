package com.ozalp.crypto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozalp.crypto.model.Crypto
import com.ozalp.crypto.service.CryptoAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel: ViewModel() {
    private val cryptoAPIService = CryptoAPIService()
    private val disposable = CompositeDisposable()
    val cryptoList = MutableLiveData<List<Crypto>>()

    fun refreshData() {
        getDataFromAPI()
    }

    private fun getDataFromAPI() {
        disposable.add(
            cryptoAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableObserver<List<Crypto>>() {
                    override fun onNext(t: List<Crypto>) {
                        cryptoList.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                    override fun onComplete() {
                        TODO("Not yet implemented")
                    }

                })
        )
    }
}