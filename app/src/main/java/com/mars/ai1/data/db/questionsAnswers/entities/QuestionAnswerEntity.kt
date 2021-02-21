package com.mars.ai1.data.db.questionsAnswers.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions_answers")
data class QuestionAnswerEntity(
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "block_id")
    val blockId: Int,
    @ColumnInfo(name = "question_id")
    val questionId: Int,
    @ColumnInfo(name = "answer_id")
    val answerId: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)