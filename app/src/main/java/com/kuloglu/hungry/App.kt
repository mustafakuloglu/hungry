package com.kuloglu.hungry

import android.content.SharedPreferences
import com.kuloglu.hungry.core.Constants
import com.kuloglu.hungry.core.DummyUsers
import com.kuloglu.hungry.di.component.DaggerApplicationComponent
import com.kuloglu.hungry.di.module.ApplicationModule
import javax.inject.Inject

class App : android.app.Application() {

    @Inject
    lateinit var pref: SharedPreferences

    val component by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        if(pref.getBoolean(Constants.FIRST_OPEN_PREF,true)){
            pref.edit().putBoolean(Constants.FIRST_OPEN_PREF,false).apply()
            DummyUsers(this).putDummyUserToDb()
        }
    }
}

