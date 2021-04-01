package com.example.serverdrivenui.HomePage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.serverdrivenui.R
import com.example.serverdrivenui.ui_components.Data
import kotlinx.android.synthetic.main.list_item.view.*


class ListAdapter(val data: List<Data>, val itemClickListener: ListItemClickListener?): RecyclerView.Adapter<ListAdapter.ItemVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
       return ItemVH.from(parent)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.bindData(data[position], itemClickListener)
    }

    override fun getItemCount() = data.size


    class ItemVH(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindData(data: Data, itemClickListener: ListItemClickListener?) {
            itemView.offer_text.text = data.text
            itemClickListener?.apply {
                itemView.setOnClickListener {
                    onClick(data)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ItemVH {
                val inflater = LayoutInflater.from(parent.context)
                return ItemVH(inflater.inflate(R.layout.list_item, parent, false))
            }
        }
    }
}
