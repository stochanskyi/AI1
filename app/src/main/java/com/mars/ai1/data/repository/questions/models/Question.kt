package com.mars.ai1.data.repository.questions.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
    val id: Int,
    val content: String,
    val answerOptions: List<AnswerOption>,
    var answer: AnswerOption?
) : Parcelable