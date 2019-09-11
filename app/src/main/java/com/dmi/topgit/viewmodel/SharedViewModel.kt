package com.dmi.topgit.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.dmi.topgit.model.GitModel

/**
 * Created by Kuldeep Saini on 11-09-2019.
 */
class SharedViewModel {
    val userData=MutableLiveData<GitModel>()
}