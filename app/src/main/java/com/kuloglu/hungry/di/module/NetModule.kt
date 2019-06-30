package com.kuloglu.hungry.di.module

import android.content.Context
import com.kuloglu.hungry.App
import com.kuloglu.hungry.service.loginservice.LoginService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetModule {
    @Singleton
    @Provides
    fun getDatabase(app: App): LoginService {
        return LoginService(app)
    }
}