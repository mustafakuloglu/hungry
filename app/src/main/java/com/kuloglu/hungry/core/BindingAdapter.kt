package com.kuloglu.hungry.core

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import androidx.databinding.BindingAdapter
import com.kuloglu.hungry.BuildConfig
import com.kuloglu.hungry.R
import com.squareup.picasso.Callback
import java.lang.Exception


object BindingAdapter {
    @JvmStatic
    @BindingAdapter("app:set_list")
    fun setList(recyclerView: RecyclerView, list: List<Nothing>?) {
        val adapter = recyclerView.adapter as BaseAdapter<*>?
        list?.let {
            adapter?.submitList(list)
        }
    }

    @JvmStatic
    @BindingAdapter("app:set_src")
    fun setSrc(imageView: ImageView, path: String) {
        if (path.isNotEmpty()) {
            Picasso.get()
                    .load(BuildConfig.PHOTO_API_URL + path +"?w=300&h=300")
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.error_black_24dp)
                    .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("app:loading_state")
    fun setLoadingState(extendedRecyclerView: ExtendedRecyclerView, isLoading: Boolean) {
        extendedRecyclerView.setLoadingState(isLoading)
    }


    @JvmStatic
    @BindingAdapter("app:visibility")
    fun setVisibilty(view: View, isVisible: Boolean) {
        view.visibility = View.GONE
        if (isVisible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("app:isActive")
    fun isActive(loginButton: Button, isActive: Boolean) {

        loginButton.isClickable = isActive

        if(isActive)
            loginButton.setBackgroundColor(ContextCompat.getColor(loginButton.context,R.color.colorAccent))
        else
            loginButton.setBackgroundColor(ContextCompat.getColor(loginButton.context,R.color.colorLoginDisabled))
    }

}