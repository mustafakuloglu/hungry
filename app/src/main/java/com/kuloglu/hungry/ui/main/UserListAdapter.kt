package com.kuloglu.hungry.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.kuloglu.hungry.App
import com.kuloglu.hungry.R
import com.kuloglu.hungry.core.BaseAdapter
import com.kuloglu.hungry.databinding.ItemUserBinding
import com.kuloglu.hungry.db.entities.User

class UserListAdapter (private val clickCallBack : (id:Long , profileView:View ) -> Unit) : BaseAdapter<User>(object : DiffUtil.ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem
}) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val viewModel = UserListAdapterViewModel(parent.context.applicationContext as App)
        val binding = DataBindingUtil.inflate<ItemUserBinding>(LayoutInflater.from(parent.context), R.layout.item_user, parent, false)
        binding.viewModel = viewModel
        binding.root.setOnClickListener {
            binding.viewModel?.let { viewModel -> viewModel.user.get()?.id?.let { id -> clickCallBack.invoke(id,binding.profile) } }
        }
        return binding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemUserBinding).viewModel?.setUser(getItem(position))
        binding.executePendingBindings()
    }

}