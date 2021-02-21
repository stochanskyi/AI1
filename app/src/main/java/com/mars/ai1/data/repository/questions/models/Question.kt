package com.mars.ai1.data.repository.questions.models

data class Question(
    val id: Long,
    val content: String,
    val answerOptions: List<AnswerOption>
)