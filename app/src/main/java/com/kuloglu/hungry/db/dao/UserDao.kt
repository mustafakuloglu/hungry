package com.kuloglu.hungry.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kuloglu.hungry.db.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getUsers(): LiveData<List<User>>

    @Query("SELECT * FROM User where id = :userId")
    fun getUser(userId: Long): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<User>)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(euser: User)

    @Query("Select count(*) from User")
    fun getCount(): Int

}