package com.dmi.topgit.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dmi.topgit.R
import com.dmi.topgit.adapter.ItemAdapter
import com.dmi.topgit.model.GitModel
import com.dmi.topgit.viewmodel.ListViewModel
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_recycle.*
import java.util.*
import kotlin.collections.ArrayList

class ListFragment : Fragment() {
    lateinit var activityRecycleBinding: com.dmi.topgit.databinding.ActivityRecycleBinding

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activityRecycleBinding = DataBindingUtil.inflate(inflater, R.layout.activity_recycle, container, false)
        return activityRecycleBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = activity?.run { ViewModelProviders.of(this).get(ListViewModel::class.java) }!!
        var layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.hasFixedSize()

        viewModel.gitHubData.observe(this, object : Observer<JsonArray> {
            override fun onChanged(t: JsonArray?) {
                val gson = Gson()
                val type6 = object : TypeToken<ArrayList<GitModel>>() {}.type

                if (t != null) {
                    val user = gson.fromJson(t.toString(), type6) as ArrayList<GitModel>




                    recyclerView.apply {


                        recyclerView.adapter = ItemAdapter(viewModel, user, context!!)
                        recyclerView.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
                        activityRecycleBinding.recycleViewModel = viewModel

                    }


                }
            }

        })

    }

}
