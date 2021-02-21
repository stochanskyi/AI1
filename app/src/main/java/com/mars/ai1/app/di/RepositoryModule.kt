package com.mars.ai1.app.di

import com.mars.ai1.data.repository.questions.QuestionRepository
import com.mars.ai1.data.repository.questions.QuestionRepositoryImpl
import com.mars.ai1.data.repository.user.UserRepository
import com.mars.ai1.data.repository.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindQuestionsRepository(repository: QuestionRepositoryImpl): QuestionRepository
    @Binds
    abstract fun bindUsersRepository(repository: UserRepositoryImpl): UserRepository
}