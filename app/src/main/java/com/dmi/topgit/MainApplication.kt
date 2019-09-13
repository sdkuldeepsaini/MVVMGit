package com.dmi.topgit

import android.content.Context
import com.dmi.finance.model.webservice.WebRepo
import com.dmi.topgit.di.DaggerApiComponent

import dagger.android.*

import javax.inject.Inject


/**
 * Created by Kuldeep Saini on 11-09-2019.
 */
class MainApplication : DaggerApplication() {
  //  @Inject lateinit var webRepo: WebRepo

    override fun applicationInjector(): AndroidInjector<MainApplication> {
        return DaggerApiComponent.builder().build()

    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }

    companion object {
        lateinit var instance: MainApplication
            private fun getContext():Context{
                return  instance.applicationContext
            }

    }
  //


}