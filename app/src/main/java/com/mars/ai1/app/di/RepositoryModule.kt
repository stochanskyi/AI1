package com.mars.ai1.app.di

import com.mars.ai1.data.questions.QuestionRepository
import com.mars.ai1.data.questions.QuestionRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindQuestionsRepository(repository: QuestionRepositoryImpl): QuestionRepository
}