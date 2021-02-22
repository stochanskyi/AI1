package com.mars.ai1.data.repository.questions.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionBlock(
    val id: Int,
    val name: String,
    val questions: List<Question>
) : Parcelable {
    val isCompleted: Boolean get() = questions.all { it.answer != null }
}