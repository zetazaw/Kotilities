package net.konyan.frameworkandextensions.extension

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class GenericAdapter<T>(val items: List<T>,
                                 val layoutResId: Int,
                                 val binder: View.(T) -> Unit):
        RecyclerView.Adapter<GenericAdapter.Holder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(layoutResId, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.itemView?.binder(item)
    }

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView)

    class Adapter<ITEM>(items: List<ITEM>,
                        layoutResId: Int,
                        bindHolder: View.(ITEM) -> Unit)
        : GenericAdapter<ITEM>(items, layoutResId, bindHolder)

}