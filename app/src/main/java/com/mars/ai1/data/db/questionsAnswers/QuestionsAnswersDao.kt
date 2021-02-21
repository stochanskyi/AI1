package com.mars.ai1.data.db.questionsAnswers

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mars.ai1.data.db.questionsAnswers.entities.QuestionAnswerEntity

@Dao
interface QuestionsAnswersDao {

    @Query("SELECT * FROM questions_answers WHERE user_id=:userId")
    suspend fun getQuestionsForUser(userId: Int): List<QuestionAnswerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswers(answers: List<QuestionAnswerEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswer(answer: QuestionAnswerEntity)

    @Query("DELETE FROM questions_answers WHERE block_id=:blockId AND user_id=:userId")
    suspend fun deleteAnswersForBlock(userId: Int, blockId: Int)
}