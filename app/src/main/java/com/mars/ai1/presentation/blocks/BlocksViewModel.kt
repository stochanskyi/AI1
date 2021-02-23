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

    private val _toBlockStatistics: SingleLiveData<QuestionBlock> = SingleLiveData()
    val toBlockStatistics: LiveData<QuestionBlock> = _toBlockStatistics

    private val _toTestStatistics: SingleLiveData<List<QuestionBlock>> = SingleLiveData()
    val toTestStatistics: LiveData<List<QuestionBlock>> = _toTestStatistics

    init {
        viewModelScope.launch {
            blocks = questionsRepository.getQuestionBlocks()
            updateBlocksViewData()
        }
    }

    fun startBlockTest(id: Int) {
        val block = blocks.firstOrNull { it.id == id } ?: return
        _startBlockLiveData.value = block
    }

    fun showBlockStatistics(id: Int) {
        val block = blocks.firstOrNull { it.id == id } ?: return
        _toBlockStatistics.value = block
    }

    fun resetAllTest() {
        blocks.forEach { block ->
            block.questions.forEach {
                it.answer = null
            }
        }
        viewModelScope.launch {
            questionsRepository.clearAllAnswers()
            updateBlocksViewData()
        }
    }

    fun showTestStatistics() {
        _toTestStatistics.value = blocks
    }

    private fun updateBlocksViewData() {
        _blocksLiveData.value = blocks.map { it.asViewData() }
    }

    private fun QuestionBlock.asViewData(): BlockViewData {
        return BlockViewData(id, name, isCompleted)
    }
}