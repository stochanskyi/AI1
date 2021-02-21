package com.mars.ai1.presentation.blocks

import androidx.lifecycle.*
import com.mars.ai1.data.repository.questions.QuestionsRepository
import com.mars.ai1.data.repository.questions.models.QuestionBlock
import com.mars.ai1.presentation.blocks.models.BlockViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlocksViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository
) : ViewModel() {

    private val _blocksLiveData: MutableLiveData<List<BlockViewData>> = MediatorLiveData()
    val blocksLiveData: LiveData<List<BlockViewData>> = _blocksLiveData

    init {
        viewModelScope.launch {
            _blocksLiveData.value = questionsRepository.getQuestionBlocks().map { it.asViewData() }
        }
    }

    private fun QuestionBlock.asViewData(): BlockViewData {
        return BlockViewData(id, name, isCompleted)
    }
}