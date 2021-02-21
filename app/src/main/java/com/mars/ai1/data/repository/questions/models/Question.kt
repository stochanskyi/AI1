package com.mars.ai1.data.repository.questions.models

data class Question(
    val id: Int,
    val content: String,
    val answerOptions: List<AnswerOption>,
    val answer: AnswerOption?
)