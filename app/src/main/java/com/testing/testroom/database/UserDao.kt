package com.testing.testroom.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll() : List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds : IntArray) : List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last")
    fun findByName(first : String, last : String) : User

    @Query("SELECT * from user where userCode in (:userCode)")
    fun loadByUserCode(userCode : Int) : User

    @Insert
    fun insertAll(vararg users : User)

    @Delete
    fun delete(user : User)
}