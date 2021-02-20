package com.mars.ai1.data.questions

import com.mars.ai1.data.questions.models.QuestionBlock

interface QuestionRepository {
    fun getQuestionBlocks(): List<QuestionBlock>
}

class QuestionRepositoryImpl : QuestionRepository {

    override fun getQuestionBlocks(): List<QuestionBlock> {
        return mockedQuestions
    }

}