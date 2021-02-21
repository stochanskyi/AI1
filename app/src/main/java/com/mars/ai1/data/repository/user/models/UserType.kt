package com.mars.ai1.data.repository.user.models

import androidx.annotation.StringRes
import com.mars.ai1.R

enum class UserType(@StringRes val stringRes: Int) {
    Novice(R.string.novice),
    ADVANCED_BEGINNER(R.string.advanced_beginner),
    COMPETENT(R.string.competent),
    PROFICIENT(R.string.proficient),
    EXPERT(R.string.expert)
}