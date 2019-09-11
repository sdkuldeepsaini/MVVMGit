package com.dmi.topgit.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.dmi.finance.model.webservice.WebRepo
import com.dmi.topgit.model.GitModel
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class ListViewModel : ViewModel(), WebRepo.ServiceResponse {

    val gitHubData=MutableLiveData<JsonArray>()
    val userShare=MutableLiveData<GitModel>()


    init {
        WebRepo.setServiceResponse(this)
        WebRepo.getData()
    }

    override fun onSuccess(jsonObject: JsonArray) {

        gitHubData.value=jsonObject
    }

    override fun onFailure() {

    }


}
