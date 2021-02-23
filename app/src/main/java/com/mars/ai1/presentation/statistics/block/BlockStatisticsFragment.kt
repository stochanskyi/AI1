package com.mars.ai1.presentation.statistics.block

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
import com.mars.ai1.databinding.FragmentBlockStatisticsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BlockStatisticsFragment : Fragment(R.layout.fragment_block_statistics) {
    private val args: BlockStatisticsFragmentArgs by navArgs()
    private val viewModel: BlockStatisticViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        FragmentBlockStatisticsBinding.bind(view).run {
            initArgs()
            initObservers(this)
        }
    }

    private fun initArgs() {
        viewModel.setup(args.block)
    }

    private fun initObservers(binding: FragmentBlockStatisticsBinding) {
        viewModel.chartDataEntriesLiveData.observe(viewLifecycleOwner) {
            updateChart(binding, it)
        }
        viewModel.blockNameLiveData.observe(viewLifecycleOwner) {
            binding.blockNameTextView.text = getString(R.string.block_statistic, it)
        }
        viewModel.marksSumLiveData.observe(viewLifecycleOwner) {
            binding.blockSumTextView.text = getString(R.string.block_marks_sum, it)
        }
    }

    private fun updateChart(binding: FragmentBlockStatisticsBinding, data: List<DataEntry>) {
        val cartesian = AnyChart.column()
        val column = cartesian.column(data)
        column.tooltip()
            .titleFormat("{%X}")
            .position(Position.CENTER_BOTTOM)
            .anchor(Anchor.CENTER_BOTTOM)
            .offsetX(0.0)
            .offsetY(5.0)
            .format("\${%Value}{groupsSeparator: }")
        cartesian.animation(true)

        cartesian.xAxis(0).title(getString(R.string.question_number))
        cartesian.yAxis(0).title(getString(R.string.question_mark))

        binding.anyChartView.setChart(cartesian)
    }
}