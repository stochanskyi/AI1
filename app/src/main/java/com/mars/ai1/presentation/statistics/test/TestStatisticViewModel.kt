package com.mars.ai1.presentation.statistics.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.mars.ai1.data.repository.questions.models.QuestionBlock
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TestStatisticViewModel @Inject constructor() : ViewModel() {

    private val _chartDataEntriesLiveData: MutableLiveData<List<DataEntry>> = MutableLiveData()
    val chartDataEntriesLiveData: MutableLiveData<List<DataEntry>> = _chartDataEntriesLiveData

    private val _skillLevelLiveData: MutableLiveData<String> = MutableLiveData()
    val skillLevelLiveData: LiveData<String> = _skillLevelLiveData

    fun setup(blocks: List<QuestionBlock>) {
        _chartDataEntriesLiveData.value = blocks.toDataEntries()
        _skillLevelLiveData.value = blocks.maxByOrNull { it.questions.sumBy { it.answer?.mark ?: 0 } }?.name
    }

    private fun List<QuestionBlock>.toDataEntries(): List<DataEntry> {
        return map { block ->
            ValueDataEntry(block.name, block.questions.sumBy { it.answer?.mark ?: 0 })
        }
    }
}