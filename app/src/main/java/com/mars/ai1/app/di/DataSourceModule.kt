package com.mars.ai1.app.di

import com.mars.ai1.data.db.users.UserDataSourceImpl
import com.mars.ai1.data.db.users.UsersDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindUsersDataSource(dataSource: UserDataSourceImpl): UsersDataSource
}