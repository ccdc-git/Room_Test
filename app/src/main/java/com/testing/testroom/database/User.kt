package com.testing.testroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "uid") val uid : Int,
    @ColumnInfo(name = "first_name") val firstName : String?,
    @ColumnInfo(name = "last_name") val lastName : String?
){
    @PrimaryKey(autoGenerate = true) var userCode : Int = 0
    override fun toString(): String {
        return "User(uid=${this.uid}, firstName=${this.firstName}, lastName=${this.lastName}, userCode=${this.userCode}"
    }
}