package com.testing.testroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object{
        private var INSTANT :AppDatabase? = null

        fun getInstant(context : Context) : AppDatabase{
            synchronized(this){
                var instant = INSTANT
                if(instant == null){
                    instant = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "user_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instant
            }
        }
    }

}