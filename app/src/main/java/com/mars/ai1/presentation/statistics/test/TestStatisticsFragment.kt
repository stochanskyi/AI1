package com.mars.ai1.presentation.statistics.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.enums.Anchor
import com.anychart.enums.Position
import com.mars.ai1.R
import com.mars.ai1.databinding.FragmentTestStatisticsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestStatisticsFragment : Fragment(R.layout.fragment_test_statistics) {
    private val args: TestStatisticsFragmentArgs by navArgs()
    private val viewModel: TestStatisticViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        FragmentTestStatisticsBinding.bind(view).run {
            initArgs()
            initObservers(this)
        }
    }

    private fun initArgs() {
        viewModel.setup(args.blocks.toList())
    }

    private fun initObservers(binding: FragmentTestStatisticsBinding) {
        viewModel.chartDataEntriesLiveData.observe(viewLifecycleOwner) {
            updateChart(binding, it)
        }
        viewModel.skillLevelLiveData.observe(viewLifecycleOwner) {
            binding.probableResultTextView.text = getString(R.string.probable_result, it)
        }
    }

    private fun updateChart(binding: FragmentTestStatisticsBinding, data: List<DataEntry>) {
        val cartesian = AnyChart.column()
        val column = cartesian.column(data)
        column.tooltip()
            .titleFormat("{%X}")
            .position(Position.CENTER_BOTTOM)
            .anchor(Anchor.CENTER_BOTTOM)
            .format("\${%Value}{groupsSeparator: }")
        cartesian.animation(true)

        cartesian.xAxis(0).title(getString(R.string.skill_level))
        cartesian.yAxis(0).title(getString(R.string.question_mark))

        binding.anyChartView.setChart(cartesian)
    }
}