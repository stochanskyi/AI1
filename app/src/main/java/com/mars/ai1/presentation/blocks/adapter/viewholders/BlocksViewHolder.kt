package com.mars.ai1.presentation.blocks.adapter.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mars.ai1.R
import com.mars.ai1.databinding.ViewHolderBlockDescriptionBinding
import com.mars.ai1.presentation.blocks.models.BlockViewData

class BlocksViewHolder private constructor(
    private val binding: ViewHolderBlockDescriptionBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): BlocksViewHolder {
            return BlocksViewHolder(
                ViewHolderBlockDescriptionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bindSummary(
        resetClickBlock: () -> Unit,
        statisticsClickBlock: () -> Unit
    ) {
        binding.run {
            blockNameTextView.text = root.context.getString(R.string.summary)
            startButton.apply {
                text = binding.root.context.getString(R.string.reset)
                setOnClickListener { resetClickBlock() }
            }
            statisticsButton.setOnClickListener { statisticsClickBlock() }
        }
    }

    fun bind(
        data: BlockViewData,
        startClickBlock: (Int) -> Unit,
        resetBlockButton: (Int) -> Unit,
        statisticsClickBlock: (Int) -> Unit
    ) {
        binding.run {
            blockNameTextView.text = data.name
            startButton.apply {
                text = root.context.getString(
                    if (data.isCompleted) R.string.again
                    else R.string.start_test
                )

                setOnClickListener { startClickBlock(data.id) }
            }

            resetButton.apply {
                isVisible = data.isCompleted
                setOnClickListener { resetBlockButton(data.id) }
            }
            statisticsButton.apply {
                isVisible = data.isCompleted
                setOnClickListener { statisticsClickBlock(data.id) }
            }
        }
    }

    fun release() {
        binding.startButton.setOnClickListener(null)
        binding.statisticsButton.setOnClickListener(null)
        binding.resetButton.setOnClickListener(null)
    }
}