package com.kuloglu.hungry.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kuloglu.hungry.db.dao.UserDao
import com.kuloglu.hungry.db.entities.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}