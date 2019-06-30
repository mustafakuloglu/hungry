package com.kuloglu.hungry.ui.login

import android.app.Application
import android.view.View
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.kuloglu.hungry.App
import com.kuloglu.hungry.core.BaseViewModel
import com.kuloglu.hungry.service.loginservice.LoginService
import javax.inject.Inject

class LoginActivityViewModel(app:Application):BaseViewModel(app) {

    @Inject
    lateinit var service:LoginService

    val userName : ObservableField<String> = ObservableField("")
    val password : ObservableField<String> = ObservableField("")
    val isLoginActive : ObservableField<Boolean> = ObservableField(false)
    val enterActivity : ObservableField<Boolean> = ObservableField(false)
    lateinit var errorToastCallBack : () -> Unit

    init {
        (app as App).component.inject(this)
        userName.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                onTextsChanged()
            } })
        password.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                onTextsChanged()
            } })
    }

    fun onLoginClick(){
        userName.get()?.let { password.get()?.let { it1 ->
            if( service.logIn(it, it1).status)
                enterActivity.set(true)
            else
                errorToastCallBack.invoke()
        } }
    }

    fun onTextsChanged(){

        userName.get()?.let { userName -> password.get()?.let { password ->
            if(userName.length > 2 && password.length > 2)
                isLoginActive.set(true)
            else
                isLoginActive.set(false)
        } }

    }


}