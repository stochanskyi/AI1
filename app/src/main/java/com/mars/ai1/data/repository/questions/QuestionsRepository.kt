package com.mars.ai1.data.repository.questions

import com.mars.ai1.data.db.questionsAnswers.AnswersDataSource
import com.mars.ai1.data.db.questionsAnswers.entities.QuestionAnswerEntity
import com.mars.ai1.data.repository.questions.models.AnswerOption
import com.mars.ai1.data.repository.questions.models.Question
import com.mars.ai1.data.repository.questions.models.QuestionBlock
import com.mars.ai1.data.storage.UserStorage
import com.mars.ai1.data.storage.questions.QuestionsStorage
import com.mars.ai1.data.storage.questions.models.AnswerOptionDataModel
import com.mars.ai1.data.storage.questions.models.QuestionBlockDataModel
import com.mars.ai1.data.storage.questions.models.QuestionDataModel
import javax.inject.Inject

interface QuestionsRepository {
    suspend fun getQuestionBlocks(): List<QuestionBlock>
    suspend fun clearAnswers(blockId: Int)
    suspend fun answerQuestions(blockId: Int, questions: List<Question>)
}

class QuestionsRepositoryImpl @Inject constructor(
    private val userStorage: UserStorage,
    private val questionsStorage: QuestionsStorage,
    private val answersDataSource: AnswersDataSource
) : QuestionsRepository {

    override suspend fun getQuestionBlocks(): List<QuestionBlock> {
        val userId = userStorage.currentUser?.id ?: return emptyList()

        val blocks = questionsStorage.questionBlocks
        val userAnswers = answersDataSource.getUserAnswers(userId)

        return blocks.map { it.parse(userAnswers) }
    }

    override suspend fun clearAnswers(blockId: Int) {
        val userId = userStorage.currentUser?.id ?: return
        answersDataSource.clearAnswersForBlock(userId, blockId)
    }

    override suspend fun answerQuestions(blockId: Int, questions: List<Question>) {
        val userId = userStorage.currentUser?.id ?: return

        val entities = questions
            .filter { it.answer != null }
            .map { QuestionAnswerEntity(userId, blockId, it.id, it.answer!!.answerId) }

        answersDataSource.answerBlock(entities)
    }

    private fun QuestionBlockDataModel.parse(answers: List<QuestionAnswerEntity>): QuestionBlock {
        val questionsWithAnswers = questions.map { question ->
            val answer = answers.firstOrNull { it.questionId == question.id && it.blockId == id }
            question.parse(answer?.id)
        }
        return QuestionBlock(id, name, questionsWithAnswers)
    }

    private fun QuestionDataModel.parse(answerId: Int?): Question {
        return Question(
            id,
            content,
            answerOptions.map { it.parse() },
            answerId?.let { answerOptions.firstOrNull { it.answerId == answerId }?.parse() }
        )
    }

    private fun AnswerOptionDataModel.parse(): AnswerOption = AnswerOption(answerId, name, mark)
}