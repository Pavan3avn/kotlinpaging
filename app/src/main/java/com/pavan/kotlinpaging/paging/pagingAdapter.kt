package com.pavan.kotlinpaging.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pavan.kotlinpaging.models.Result
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.pavan.kotlinpaging.R
import kotlin.text.Typography.quote


class pagingAdapter() : PagingDataAdapter<Result, pagingAdapter.viewholder>(comparator) {

    class viewholder(v : View): RecyclerView.ViewHolder(v){
        val quote = v.findViewById<TextView>(R.id.quote)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.quote.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_item,parent,false)
        return viewholder(view)
    }

    companion object{
        private val comparator = object :DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }

    }

}