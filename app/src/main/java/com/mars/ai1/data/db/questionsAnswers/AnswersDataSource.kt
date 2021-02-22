package com.mars.ai1.data.db.questionsAnswers

import com.mars.ai1.data.db.questionsAnswers.entities.QuestionAnswerEntity
import com.mars.ai1.utils.withIOContext
import javax.inject.Inject

interface AnswersDataSource {
    suspend fun getUserAnswers(userId: Int): List<QuestionAnswerEntity>
    suspend fun answerBlock(answers: List<QuestionAnswerEntity>)
    suspend fun clearAnswersForBlock(userId: Int, blockId: Int)
    suspend fun clearAnswers(userId: Int)
}

class AnswersDataSourceImpl @Inject constructor(
    private val answersDao: QuestionsAnswersDao
) : AnswersDataSource {
    override suspend fun getUserAnswers(userId: Int): List<QuestionAnswerEntity> {
        return withIOContext {
            answersDao.getQuestionsForUser(userId)
        }
    }

    override suspend fun answerBlock(answers: List<QuestionAnswerEntity>) {
        withIOContext {
            answersDao.insertAnswers(answers)
        }
    }

    override suspend fun clearAnswersForBlock(userId: Int, blockId: Int) {
        withIOContext {
            answersDao.deleteAnswersForBlock(userId, blockId)
        }
    }

    override suspend fun clearAnswers(userId: Int) {
        withIOContext {
            answersDao.deleteAnswers(userId)
        }
    }
}