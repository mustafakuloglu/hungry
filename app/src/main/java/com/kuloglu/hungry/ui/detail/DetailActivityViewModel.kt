package com.kuloglu.hungry.ui.detail

import android.app.Application
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.kuloglu.hungry.App
import com.kuloglu.hungry.core.BaseViewModel
import com.kuloglu.hungry.db.AppDatabase
import com.kuloglu.hungry.db.entities.User
import com.kuloglu.hungry.utils.Validator
import org.jetbrains.anko.doAsync
import java.util.regex.Pattern
import javax.inject.Inject

class DetailActivityViewModel(app: Application) : BaseViewModel(app) {

    val user: ObservableField<User> = ObservableField(User())
    val saveVisibility: ObservableField<Boolean> = ObservableField(false)
    lateinit var errorToastCallBack : () -> Unit
    private val validator = Validator()

    @Inject
    lateinit var db: AppDatabase

    init {
        (app as? App)?.component?.inject(this)
    }


    fun setUser(id: Long) {
        doAsync { user.set(db.userDao().getUser(id)) }
    }

    fun onTextChanged() {
        saveVisibility.set(true)
    }


    fun saveClick() {
        user.get()?.let {
            if (validator.validateUserData(it)){
                doAsync {  db.userDao().insertUser(it)  }
                saveVisibility.set(false)
            }
            else
            {
                errorToastCallBack.invoke()
                saveVisibility.set(true)
            }

        }
    }

}