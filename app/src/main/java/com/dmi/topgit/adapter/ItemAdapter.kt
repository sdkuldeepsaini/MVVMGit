package com.dmi.topgit.adapter

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Handler
import android.support.v7.widget.RecyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import com.dmi.topgit.R
import com.dmi.topgit.databinding.ItemViewBinding
import com.dmi.topgit.model.GitModel
import com.dmi.topgit.viewmodel.ListViewModel
import android.support.v7.app.AppCompatActivity

import com.dmi.topgit.view.DetailFragment



class ItemAdapter(viewModel: ListViewModel, mlist: List<GitModel>, context: Context) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    val mlist = mlist
    val mContext = context
    val viewModel1 = viewModel
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MyViewHolder {

        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.item_view,
            viewGroup,
            false
        ) as com.dmi.topgit.databinding.ItemViewBinding


        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.e("size is", "${mlist?.size}")
        return mlist.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, p1: Int) {
        val itemViewBinding = viewHolder.itemViewBinding
        val data = mlist.get(p1)
        itemViewBinding.item = data

        /**
         *  Handle click here BTW you can also handle using DataBinding
         */



        itemViewBinding.clickItem.setOnClickListener {

            val manager = (mContext as AppCompatActivity).supportFragmentManager.beginTransaction()
            val detailFragment = DetailFragment()
            manager.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            manager.replace(R.id.flContainer, detailFragment)
            manager.addToBackStack(null)
            manager.commit()
            viewModel1.userShare.value = data  // Observe the data


        }


    }

    inner class MyViewHolder(itemViewBinding: ItemViewBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {

        val itemViewBinding = itemViewBinding


    }

    companion object {
        @JvmStatic
        @BindingAdapter("avatar")
        fun bindImage(imageView: ImageView, imageUrl: String) {
            ImageLoader.displayImage(imageUrl, imageView)
        }


    }

}