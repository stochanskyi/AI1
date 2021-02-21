package com.mars.ai1.data.questions

import com.mars.ai1.data.questions.models.QuestionBlock
import javax.inject.Inject

interface QuestionRepository {
    fun getQuestionBlocks(): List<QuestionBlock>
}

class QuestionRepositoryImpl @Inject constructor() : QuestionRepository {

    override fun getQuestionBlocks(): List<QuestionBlock> {
        return mockedQuestions
    }

}