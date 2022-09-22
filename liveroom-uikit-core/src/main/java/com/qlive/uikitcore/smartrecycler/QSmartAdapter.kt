package com.qlive.uikitcore.smartrecycler

import androidx.recyclerview.widget.RecyclerView
import com.qlive.uikitcore.adapter.QRecyclerViewHolder
import com.qlive.uikitcore.adapter.QMultipleItemRvAdapter
import com.qlive.uikitcore.adapter.QRecyclerAdapter

abstract class QSmartAdapter<T> : QRecyclerAdapter<T>, IAdapter<T> {
    constructor(@androidx.annotation.LayoutRes resID: Int) : super(resID)
    constructor(@androidx.annotation.LayoutRes resID: Int, data: List<T>) : super(resID, data)

    override fun bindRecycler(recyclerView: RecyclerView) {
        this.bindToRecyclerView(recyclerView)
    }

    override fun addDataList(mutableList: MutableList<T>) {
        addData(mutableList)
    }

    override fun setNewDataList(mutableList: MutableList<T>) {
        setNewData(mutableList)
    }

    override fun isCanShowEmptyView(): Boolean {
        return this.data.isEmpty() && (this.headerLayoutCount + this.footerLayoutCount == 0)
    }
}

abstract class QSmartMultipleAdapter<T>(data: List<T>) : QMultipleItemRvAdapter<T>(data),
    IAdapter<T> {
    override fun bindRecycler(recyclerView: RecyclerView) {
        this.bindToRecyclerView(recyclerView)
    }

    override fun addDataList(mutableList: MutableList<T>) {
        addData(mutableList)
    }

    override fun setNewDataList(mutableList: MutableList<T>) {
        setNewData(mutableList)
    }

    override fun isCanShowEmptyView(): Boolean {
        return this.data.isEmpty() && (this.headerLayoutCount + this.footerLayoutCount == 0)
    }
}