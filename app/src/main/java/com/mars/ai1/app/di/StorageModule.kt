package com.mars.ai1.app.di

import com.mars.ai1.data.storage.UserStorage
import com.mars.ai1.data.storage.UserStorageImpl
import com.mars.ai1.data.storage.questions.QuestionsStorage
import com.mars.ai1.data.storage.questions.QuestionsStorageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    @Singleton
    abstract fun bindUserStorage(storage: UserStorageImpl): UserStorage

    @Binds
    @Singleton
    abstract fun bindQuestionsStorage(storage: QuestionsStorageImpl): QuestionsStorage

}