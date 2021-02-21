package com.mars.ai1.app.di

import com.mars.ai1.data.storage.UserStorage
import com.mars.ai1.data.storage.UserStorageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    abstract fun bindUserStorage(storage: UserStorageImpl): UserStorage
}