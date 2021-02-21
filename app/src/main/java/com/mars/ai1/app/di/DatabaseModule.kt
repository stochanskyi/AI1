package com.mars.ai1.app.di

import android.content.Context
import android.service.controls.templates.ControlTemplate
import androidx.room.Dao
import androidx.room.Room
import com.mars.ai1.data.db.common.AppDatabase
import com.mars.ai1.data.db.users.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "Lab db").build()
    }

    @Provides
    fun provideUsersDao(
        db: AppDatabase
    ): UsersDao {
        return db.usersDao
    }
}