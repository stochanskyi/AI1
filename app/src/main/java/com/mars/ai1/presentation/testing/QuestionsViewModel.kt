package com.mars.ai1.presentation.testing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mars.ai1.data.repository.questions.QuestionsRepository
import com.mars.ai1.data.repository.questions.models.Question
import com.mars.ai1.data.repository.questions.models.QuestionBlock
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val repository: QuestionsRepository
) : ViewModel() {

    private lateinit var block: QuestionBlock

    fun setup(block: QuestionBlock) {
        this.block = block
        _questionsLiveData.value = block.questions
        _blockNameLiveData.value = block.name
    }

    private val _questionsLiveData: MutableLiveData<List<Question>> = MutableLiveData()
    val questionsLiveData: LiveData<List<Question>> = _questionsLiveData

    private val _blockNameLiveData: MutableLiveData<String> = MutableLiveData()
    val blockNameLiveData: LiveData<String> = _blockNameLiveData

    private val _isSaveEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val isSaveEnabled: LiveData<Boolean> = _isSaveEnabled

    fun setQuestionAnswer(questionId: Int, answerId: Int) {
        val question = block.questions.firstOrNull { it.id == questionId } ?: return

        question.answer = question.answerOptions.firstOrNull { it.answerId == answerId }
        validateAnswers()
    }

    fun saveAnswers() {
        viewModelScope.launch {
            repository.answerQuestions(block.id, block.questions)
        }
    }

    private fun validateAnswers() {
        _isSaveEnabled.value = block.questions.all { it.answer != null }
    }

}