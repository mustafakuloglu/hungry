package com.kuloglu.hungry.service.loginservice

import com.kuloglu.hungry.App
import com.kuloglu.hungry.db.AppDatabase
import com.kuloglu.hungry.db.entities.LoginModel
import javax.inject.Inject

class LoginService(val app:App) {

    @Inject
    lateinit var db: AppDatabase

    init {
        app.component.inject(this)
    }

    fun logIn(userName:String , password: String):LoginModel{
        var status = false
        if(userName == "yemek" && password == "123")
            status = true
        return LoginModel(1,status)
    }
}