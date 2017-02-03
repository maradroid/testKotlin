package com.maradroid.testkotlin.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maradroid.testkotlin.R
import com.maradroid.testkotlin.model.data_model.Data
import java.util.*
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by mara on 2/3/17.
 */
class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataList: List<Data> = emptyList()


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ViewHolder) {
            holder.tvTitle.text = dataList.get(position).item.title
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        val tvTitle = itemView.tv_text // itemView je tako tu sam od sebe XD
    }

    fun setData(data: List<Data>?) {
        if (data != null && !data.isEmpty()) {
            dataList = emptyList()
            dataList = data
            notifyDataSetChanged()
        }
    }
}
