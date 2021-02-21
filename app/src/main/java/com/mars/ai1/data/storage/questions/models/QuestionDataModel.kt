package com.mars.ai1.data.storage.questions.models

data class QuestionDataModel(
    val id: Int,
    val content: String,
    val answerOptions: List<AnswerOptionDataModel>
)