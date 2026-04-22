package com.danyglaz.yaduvankinapp.di

import android.content.Context
import androidx.room.Room
import com.danyglaz.yaduvankinapp.data.database.UserDataBase
import com.danyglaz.yaduvankinapp.domain.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDataBase{
        return Room.databaseBuilder(
            context,
            UserDataBase::class.java,
            "userDataBase.db"
        ).build()
    }
    @Provides
    @Singleton //чтобы объекты не пересоздавались
    fun provideUserDao(userDatabase: UserDataBase): UserDao{
        return userDatabase.getUserDao()
    }
}