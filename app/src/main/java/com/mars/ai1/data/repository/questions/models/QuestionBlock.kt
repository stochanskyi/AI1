package com.mars.ai1.data.repository.questions.models

data class QuestionBlock(
    val id: Int,
    val name: String,
    val questions: List<Question>
) {
    val isCompleted: Boolean get() = questions.all { it.answer != null }
}