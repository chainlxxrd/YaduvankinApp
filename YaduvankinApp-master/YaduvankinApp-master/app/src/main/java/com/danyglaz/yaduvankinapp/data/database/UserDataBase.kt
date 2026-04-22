package com.danyglaz.yaduvankinapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danyglaz.yaduvankinapp.domain.dao.UserDao
import com.danyglaz.yaduvankinapp.domain.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
}