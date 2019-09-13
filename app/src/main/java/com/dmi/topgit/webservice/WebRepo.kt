package com.dmi.finance.model.webservice


import com.dmi.topgit.MainApplication
import com.dmi.topgit.di.ApiModule
import com.google.gson.JsonArray

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class WebRepo @Inject constructor(private val apiModule: ApiModule) {

    private  var newsApi: WebService
    private lateinit var serviceResponse: ServiceResponse
    lateinit  var observable: Observable<JsonArray>
    private val compositeDisposable=apiModule.providesCompositeDisposable()
    private val application=apiModule.providesMainApplication()
    private  val okHttpCache=apiModule.provideHttpCache(application.applicationContext)
    private  val okHttpClient=apiModule.provideOkhttpClient(okHttpCache,application)
    private val retrofit=apiModule.provideRetrofit(okHttpClient)

    init {

        newsApi = cteateService(WebService::class.java)
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
    fun <S> cteateService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }



}