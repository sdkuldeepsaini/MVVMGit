package com.dmi.topgit.viewmodel

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import android.content.Context
import com.dmi.finance.model.webservice.WebRepo
import com.dmi.topgit.MainApplication
import com.dmi.topgit.model.GitModel
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import javax.inject.Inject
import javax.inject.Named


class ListViewModel @Inject constructor(webRepo: WebRepo) : ViewModel(), WebRepo.ServiceResponse {




    val gitHubData=MutableLiveData<JsonArray>()
    val userShare=MutableLiveData<GitModel>()



    init {

      //  webRepo= WebRepo(context )
        webRepo.setServiceResponse(this)
        webRepo.getData()
    }

    override fun onSuccess(jsonObject: JsonArray) {

        gitHubData.value=jsonObject
    }

    override fun onFailure() {

    }


}
