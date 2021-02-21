package com.mars.ai1.data.storage.questions.models

data class QuestionBlockDataModel(
    val id: Int,
    val name: String,
    val questions: List<QuestionDataModel>
)