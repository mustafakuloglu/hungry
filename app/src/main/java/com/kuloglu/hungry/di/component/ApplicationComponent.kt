package com.kuloglu.hungry.di.component

import android.content.Context
import android.content.SharedPreferences
import com.kuloglu.hungry.App
import com.kuloglu.hungry.core.DummyUsers
import com.kuloglu.hungry.di.module.ApplicationModule
import com.kuloglu.hungry.di.module.DatabaseModule
import com.kuloglu.hungry.di.module.NetModule
import com.kuloglu.hungry.service.loginservice.LoginService
import com.kuloglu.hungry.ui.detail.DetailActivityViewModel
import com.kuloglu.hungry.ui.login.LoginActivityViewModel
import com.kuloglu.hungry.ui.main.MainActivityViewModel

import dagger.Component
import javax.inject.Singleton


@Singleton


@Component(modules = [ApplicationModule::class, DatabaseModule::class, NetModule::class])

interface ApplicationComponent {
    fun app(): App


    fun context(): Context

    fun preferences(): SharedPreferences

    fun inject(mainActivityViewModel: MainActivityViewModel)

    fun inject(mainActivityViewModel: App)

    fun inject(dummyUsers: DummyUsers)

    fun inject(detailActivityViewModel: DetailActivityViewModel)

    fun inject(loginActivityViewModel: LoginActivityViewModel)

    fun inject(loginService: LoginService)
}
