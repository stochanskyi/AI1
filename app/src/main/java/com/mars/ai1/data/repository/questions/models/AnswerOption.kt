package com.mars.ai1.data.repository.questions.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnswerOption(
    val answerId: Int,
    val name: String,
    val mark: Int
) : Parcelable