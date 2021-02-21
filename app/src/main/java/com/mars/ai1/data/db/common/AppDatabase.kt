package com.mars.ai1.data.db.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mars.ai1.data.db.questionsAnswers.QuestionsAnswersDao
import com.mars.ai1.data.db.questionsAnswers.entities.QuestionAnswerEntity
import com.mars.ai1.data.db.users.UsersDao
import com.mars.ai1.data.db.users.entities.UserEntity

@Database(entities = [UserEntity::class, QuestionAnswerEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val usersDao: UsersDao
    abstract val questionsAnswersDao: QuestionsAnswersDao
}