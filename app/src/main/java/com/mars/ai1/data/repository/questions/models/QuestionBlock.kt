package com.mars.ai1.data.repository.questions.models

data class QuestionBlock(
    val id: Long,
    val name: String,
    val questions: List<Question>
)