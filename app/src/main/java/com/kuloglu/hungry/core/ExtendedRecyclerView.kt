package com.kuloglu.hungry.core


import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExtendedRecyclerView : RecyclerView {

    private var emptyView: View? = null
    private var loadingView: View? = null
    private var countTextView: TextView? = null
    private var isCountTextAdd: Boolean = false
    private var isLoading = false
    private val emptyObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            checkIfEmpty()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            checkIfEmpty()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            checkIfEmpty()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
            checkIfEmpty()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            checkIfEmpty()
        }
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)


    private fun checkIfEmpty() {
        if (context is Activity && !isLoading)
            (context as Activity).runOnUiThread {
                val count: Int
                if (adapter != null && adapter!!.itemCount == 0) {
                    if (loadingView != null)
                        loadingView!!.visibility = View.GONE
                    count = adapter!!.itemCount
                    if (this@ExtendedRecyclerView.countTextView != null) {
                        if (isCountTextAdd) {
                            countTextView!!.text = String.format("%s Adet", count)
                        } else {
                            countTextView!!.text = count.toString()
                        }
                    }
                    if (emptyView != null) {
                        val emptyViewVisible = count == 0
                        emptyView!!.visibility = if (emptyViewVisible) View.VISIBLE else View.GONE
                        visibility = if (!emptyViewVisible) {
                            View.VISIBLE
                        } else
                            View.GONE
                    }
                } else if (adapter != null && adapter!!.itemCount != 0) {
                    if (loadingView != null) {
                        loadingView!!.visibility = View.GONE
                    }
                    if (emptyView != null) {
                        emptyView!!.visibility = View.GONE
                    }
                    visibility = View.VISIBLE
                } else if (loadingView != null && isLoading) {
                    loadingView!!.visibility = View.VISIBLE
                    visibility = View.GONE

                }
            }
    }

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(emptyObserver)
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(emptyObserver)
        checkIfEmpty()
        emptyObserver.onChanged()
    }

    fun setEmptyView(emptyView: View?) {
        if (emptyView == null)
            return
        this.emptyView = emptyView
        this.emptyView?.visibility = View.GONE
        checkIfEmpty()
    }

    fun setLoadingView(loadingView: View?) {
        if (loadingView == null)
            return
        this.loadingView = loadingView
        checkIfEmpty()
    }

    fun setLoadingState(isLoading: Boolean) {
        if (isLoading)
            enableLoadingView()
        else
            disableLoadingView()
    }

    private fun enableLoadingView() {
        if (loadingView == null)
            return
        loadingView!!.visibility = View.VISIBLE
        visibility = View.INVISIBLE
        this.emptyView?.visibility = View.GONE
        isLoading = true
    }

    private fun disableLoadingView() {
        if (loadingView == null)
            return
        loadingView!!.visibility = View.GONE
        visibility = View.VISIBLE
        isLoading = false
        checkIfEmpty()
    }
}
