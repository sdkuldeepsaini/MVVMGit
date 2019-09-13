package com.bubelov.coins.dagger


import com.bubelov.coins.ui.fragment.DetailFragmentModule
import com.bubelov.coins.ui.fragment.ListFragmentModule
import com.dmi.topgit.view.DetailFragment
import com.dmi.topgit.view.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Igor Bubelov
 */

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = arrayOf(ListFragmentModule::class))
    abstract fun contributeListFragmentInjector(): ListFragment

    @ContributesAndroidInjector(modules = arrayOf(DetailFragmentModule::class))
    abstract fun contributeDetailFragmentInjector(): DetailFragment


}