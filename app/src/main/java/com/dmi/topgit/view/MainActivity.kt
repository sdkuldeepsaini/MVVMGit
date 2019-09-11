package com.dmi.topgit.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dmi.topgit.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ImageLoader.with(context).load(holder.imageView, items[position])
    }
}
