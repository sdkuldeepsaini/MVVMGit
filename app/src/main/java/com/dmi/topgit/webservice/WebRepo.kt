package com.dmi.finance.model.webservice

import android.util.Log
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


object WebRepo {

    private  var newsApi: WebService
    private lateinit var serviceResponse: ServiceResponse
    lateinit  var observable: Observable<JsonArray>
    val compositeDisposable= CompositeDisposable()

    init {
        newsApi = RetrofitService.cteateService(WebService::class.java)
    }

    fun getData()
    {
        //You can handle network connection here

        observable=  newsApi.getUserList("java","weekly")
        compositeDisposable.add(observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<JsonArray>(){
                override fun onComplete() {

                }

                override fun onError(e: Throwable) {

                    serviceResponse.onFailure()
                }

                override fun onNext(t: JsonArray) {

                    serviceResponse.onSuccess(t)



                }

            }))

    }

    fun setServiceResponse(serviceResponse: ServiceResponse) {
        this.serviceResponse = serviceResponse
    }

    interface ServiceResponse {
        fun onSuccess(jsonObject: JsonArray)
        fun onFailure()

    }



}