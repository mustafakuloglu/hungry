package com.kuloglu.hungry.ui.main

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.kuloglu.hungry.db.AppDatabase
import com.kuloglu.hungry.App
import com.kuloglu.hungry.core.BaseViewModel
import com.kuloglu.hungry.db.entities.User
import javax.inject.Inject

class MainActivityViewModel(app: Application) : BaseViewModel(app) {

    @Inject
    lateinit var db: AppDatabase
    val loadingState: ObservableField<Boolean> = ObservableField(true)
    val userList : ObservableField<List<User>> = ObservableField(emptyList())


    init {
        (app as? App)?.component?.inject(this)
    }

    fun getUsers() :LiveData<List<User>>{
        loadingState.set(true)
        return db.userDao().getUsers()
    }
    fun setUserList(list: List<User>?) {

        list?.let {
            loadingState.set(false)
            userList.set(it) }
    }


}