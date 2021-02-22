package com.mars.ai1.presentation.blocks

import androidx.lifecycle.*
import com.mars.ai1.data.repository.questions.QuestionsRepository
import com.mars.ai1.data.repository.questions.models.QuestionBlock
import com.mars.ai1.presentation.blocks.models.BlockViewData
import com.mars.ai1.utils.livedata.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlocksViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository
) : ViewModel() {

    private lateinit var blocks: List<QuestionBlock>

    private val _blocksLiveData: MutableLiveData<List<BlockViewData>> = MediatorLiveData()
    val blocksLiveData: LiveData<List<BlockViewData>> = _blocksLiveData

    private val _startBlockLiveData: SingleLiveData<QuestionBlock> = SingleLiveData()
    val startBlockLiveData: LiveData<QuestionBlock> = _startBlockLiveData

    init {
        viewModelScope.launch {
            blocks = questionsRepository.getQuestionBlocks()
            _blocksLiveData.value = blocks.map { it.asViewData() }
        }
    }

    fun startBlockTest(id: Int) {
        viewModelScope.launch {
            val block = blocks.firstOrNull { it.id == id } ?: return@launch

            questionsRepository.clearAnswers(id)
            block.questions.forEach { it.answer = null }

            _startBlockLiveData.value = block
        }
    }

    private fun QuestionBlock.asViewData(): BlockViewData {
        return BlockViewData(id, name, isCompleted)
    }
}