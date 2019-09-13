package com.dmi.topgit.di

import com.dmi.finance.model.webservice.RetrofitService
import com.dmi.topgit.MainApplication
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.dmi.finance.model.webservice.WebRepo
import com.dmi.topgit.viewmodel.ListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass


/**
 * Created by Kuldeep Saini on 12-09-2019.
 */

class ApiModule @Inject constructor() {

    fun provideOkhttpClient(cache:Cache,application: Context):OkHttpClient{

        val okHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (RetrofitService.hasNetwork(application)!!)
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                chain.proceed(request)
            }
            .build()
        return  okHttpClient
    }


    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://github-trending-api.now.sh")  //You can Get from JNI for security reason
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        return  retrofit
    }


    fun provideHttpCache(application: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }


    fun providesCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }


    fun providesMainApplication(): Context {
        return MainApplication.instance
    }




}


