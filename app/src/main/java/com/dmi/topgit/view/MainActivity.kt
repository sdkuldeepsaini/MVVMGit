package com.dmi.topgit.view

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dmi.topgit.MainApplication
import com.dmi.topgit.R
import com.dmi.topgit.viewmodel.ListViewModel
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
        ******************************************************
        * Check if instance is null and add List Fragment
        * ****************************************************
        */
        if (savedInstanceState==null)
        {
                val  gitListFragment=ListFragment()
                val ft=supportFragmentManager.beginTransaction()
                ft.add(R.id.flContainer,gitListFragment)
                ft.commit()
        }




    }
}
