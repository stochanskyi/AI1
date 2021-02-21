package com.mars.ai1.data.repository.questions

import com.mars.ai1.data.repository.questions.models.QuestionBlock
import javax.inject.Inject

interface QuestionRepository {
    fun getQuestionBlocks(): List<QuestionBlock>
}

class QuestionRepositoryImpl @Inject constructor() : QuestionRepository {

    override fun getQuestionBlocks(): List<QuestionBlock> {
        return mockedQuestions
    }

}