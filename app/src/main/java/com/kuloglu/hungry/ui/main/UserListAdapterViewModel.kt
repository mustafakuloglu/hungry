package com.kuloglu.hungry.ui.main

import androidx.databinding.ObservableField
import com.kuloglu.hungry.App
import com.kuloglu.hungry.core.BaseViewModel
import com.kuloglu.hungry.db.entities.User

class UserListAdapterViewModel(app:App) : BaseViewModel(app){
    val user : ObservableField<User> = ObservableField(User())

    fun setUser(user:User){
        this.user.set(user)
    }
}