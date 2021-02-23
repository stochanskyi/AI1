package com.mars.ai1.presentation.statistics.block

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.mars.ai1.data.repository.questions.models.QuestionBlock
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BlockStatisticViewModel @Inject constructor() : ViewModel() {

    private val _chartDataEntriesLiveData: MutableLiveData<List<DataEntry>> = MutableLiveData()
    val chartDataEntriesLiveData: MutableLiveData<List<DataEntry>> = _chartDataEntriesLiveData

    private val _marksSumLiveData: MutableLiveData<Int> = MutableLiveData()
    val marksSumLiveData: LiveData<Int> = _marksSumLiveData

    private val _blockNameLiveData: MutableLiveData<String> = MutableLiveData()
    val blockNameLiveData: LiveData<String> = _blockNameLiveData

    fun setup(block: QuestionBlock) {
        _chartDataEntriesLiveData.value = block.toDataEntries()
        _blockNameLiveData.value = block.name
        _marksSumLiveData.value = block.questions.sumBy { it.answer?.mark ?: 0 }
    }

    private fun QuestionBlock.toDataEntries(): List<DataEntry> {
        return questions.mapIndexed { index, question ->
            ValueDataEntry(index + 1, question.answer?.mark ?: 0)
        }
    }
}
