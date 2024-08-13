package com.ozalp.crypto.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ozalp.crypto.model.Crypto
import com.ozalp.crypto.viewmodel.MainActivityViewModel
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        compositeComposable = CompositeDisposable()

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.refreshData()

        viewModel.cryptoList.observe(this, Observer {
            if (it.isNotEmpty())
                println(it)
        })
    }

    private var compositeComposable: CompositeDisposable? = null
    private lateinit var viewModel: MainActivityViewModel
}