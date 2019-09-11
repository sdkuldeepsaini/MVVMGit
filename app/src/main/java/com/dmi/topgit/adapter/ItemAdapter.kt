package com.dmi.topgit.adapter

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import com.dmi.topgit.R
import com.dmi.topgit.databinding.ItemViewBinding
import com.dmi.topgit.model.GitModel


class ItemAdapter (mlist:List<GitModel>,context: Context): RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    val mlist=mlist
    val mContext=context
    private var mCurrentMonth = ""
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MyViewHolder {

        val binding= DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context), R.layout.item_view,viewGroup,false) as com.dmi.topgit.databinding.ItemViewBinding


        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.e("size is", "${mlist?.size}")
        if (mlist != null) {
            return mlist.size
        }
        else
        {
            return 0
        }
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, p1: Int) {
        val itemViewBinding=viewHolder.itemViewBinding
        if (mlist != null) {
            val data=mlist.get(p1)
            itemViewBinding.item=data




                itemViewBinding.clickItem.setOnClickListener(View.OnClickListener {

                 /* val intent=  Intent(mContext,DetailActivity::class.java)
                    intent.putExtra("data",data)
                    mContext.startActivity(intent)*/

                })

        }



    }

    inner  class MyViewHolder(itemViewBinding: ItemViewBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {

        val itemViewBinding=itemViewBinding





    }

     companion object {
         @JvmStatic
        @BindingAdapter("avatar")
        fun bindImage(imageView: ImageView, imageUrl: String) {
             ImageLoader.displayImage(imageUrl,imageView)
        }


    }

}