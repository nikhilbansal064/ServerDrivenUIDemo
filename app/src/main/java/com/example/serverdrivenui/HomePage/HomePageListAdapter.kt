package com.example.serverdrivenui.HomePage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serverdrivenui.R
import com.example.serverdrivenui.ui_components.Component
import com.example.serverdrivenui.ui_components.Data
import kotlinx.android.synthetic.main.component_banner.view.*

import kotlinx.android.synthetic.main.grid_list.view.*
import kotlinx.android.synthetic.main.horizontal_list.view.*

class HomePageListAdapter(val components: List<Component>,
                          val clickListener: ComponentClickListener? = null,
                          val nestedItemListener: ListItemClickListener? = null): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ComponentType.BANNER.ordinal -> BannerVH.from(parent)
            ComponentType.HORIZONTAL_LIST.ordinal -> HorizontalListVH.from(parent)
            ComponentType.GRID_LIST.ordinal -> GridListVH.from(parent)
            else -> BannerVH.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UIComponentVH -> holder.bindData(components[position], clickListener)
            is NestedListUIComponentVH -> holder.bindData(components[position], clickListener, nestedItemListener)
        }
    }

    override fun getItemCount() = components.size

    override fun getItemViewType(position: Int): Int {
        return when (components[position].viewType) {
            "Banner" -> ComponentType.BANNER.ordinal
            "list_horizontal" -> ComponentType.HORIZONTAL_LIST.ordinal
            "list_grid" -> ComponentType.GRID_LIST.ordinal
            else -> 0
        }
    }
}


abstract class UIComponentVH(item: View): RecyclerView.ViewHolder(item) {
    abstract fun bindData(component: Component, clickListener: ComponentClickListener?)
}

abstract class NestedListUIComponentVH(item: View): RecyclerView.ViewHolder(item) {
    abstract fun bindData(component: Component,
                          clickListener: ComponentClickListener?,
                          nestedItemListener: ListItemClickListener?)
}

class BannerVH(itemView: View): UIComponentVH(itemView) {

    override fun bindData(component: Component, clickListener: ComponentClickListener?) {
        itemView.banner_text.text = component.text
        clickListener?.apply {
            itemView.setOnClickListener {
                onClick(component)
            }
        }

    }

    companion object {
        fun from(parent: ViewGroup): BannerVH {
            val inflater = LayoutInflater.from(parent.context)
            return BannerVH(inflater.inflate(R.layout.component_banner, parent, false))
        }
    }

}

class HorizontalListVH(itemView: View): NestedListUIComponentVH(itemView) {

    override fun bindData(
        component: Component,
        clickListener: ComponentClickListener?,
        nestedItemListener: ListItemClickListener?
    ) {
        val listIterator = ListAdapter(component.data, nestedItemListener)
        itemView.horizontal_list.adapter = listIterator

    }

    companion object {
        fun from(parent: ViewGroup): HorizontalListVH {
            val inflater = LayoutInflater.from(parent.context)
            return HorizontalListVH(inflater.inflate(R.layout.horizontal_list, parent, false))
        }
    }
}

class GridListVH(itemView: View): NestedListUIComponentVH(itemView) {


    override fun bindData(
        component: Component,
        clickListener: ComponentClickListener?,
        nestedItemListener: ListItemClickListener?
    ) {
        val listAdapter = ListAdapter(component.data, nestedItemListener)
        itemView.grid_list.layoutManager = GridLayoutManager(itemView.context, 2)
        itemView.grid_list.adapter = listAdapter
    }

    companion object {
        fun from(parent: ViewGroup): GridListVH {
            val inflater = LayoutInflater.from(parent.context)
            return GridListVH(inflater.inflate(R.layout.grid_list, parent, false))
        }
    }
}


class ComponentClickListener(val onClick: (component: Component) -> Unit)
class ListItemClickListener(val onClick: (data: Data) -> Unit)

enum class ComponentType(type: Int) {
    BANNER(1), HORIZONTAL_LIST(2), GRID_LIST(2)
}
