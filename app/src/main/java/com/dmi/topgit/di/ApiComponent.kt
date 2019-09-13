package com.dmi.topgit.di

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentActivity
import com.bubelov.coins.dagger.FragmentBuilder

import com.dmi.finance.model.webservice.WebRepo
import com.dmi.topgit.MainApplication
import com.dmi.topgit.view.ListFragment
import com.dmi.topgit.view.MainActivity
import com.dmi.topgit.viewmodel.ListViewModel
import dagger.BindsInstance

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import java.util.*
import javax.inject.Singleton

/**
 * Created by Kuldeep Saini on 12-09-2019.
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class,AndroidSupportInjectionModule::class, ViewModelModule::class, FragmentBuilder::class])
interface ApiComponent : AndroidInjector<MainApplication> {
        fun inject(target:ListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ApiComponent



    }



}