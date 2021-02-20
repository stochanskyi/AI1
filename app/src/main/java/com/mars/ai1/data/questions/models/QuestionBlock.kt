package com.mars.ai1.data.questions.models

data class QuestionBlock(
    val id: Long,
    val name: String,
    val questions: List<Question>
)