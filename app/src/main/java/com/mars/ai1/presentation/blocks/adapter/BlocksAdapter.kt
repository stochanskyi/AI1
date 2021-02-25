package com.mars.ai1.presentation.blocks.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mars.ai1.presentation.blocks.adapter.viewholders.BlocksViewHolder
import com.mars.ai1.presentation.blocks.models.BlockViewData

class BlocksAdapter(
    private val startQuestionsBlock: (Int) -> Unit,
    private val resetBlock: (Int) -> Unit,
    private val statisticsBlock: (Int) -> Unit,
    private val resetTestBlock: () -> Unit,
    private val testStatisticsBlock: () -> Unit
) : RecyclerView.Adapter<BlocksViewHolder>() {

    private val items: MutableList<BlockViewData> = mutableListOf()

    fun setItems(items: List<BlockViewData>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlocksViewHolder {
        return BlocksViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BlocksViewHolder, position: Int) {
        if (position == 0) holder.bindSummary(resetTestBlock, testStatisticsBlock)
        else holder.bind(items[position - 1], startQuestionsBlock, resetBlock, statisticsBlock)
    }

    override fun onViewRecycled(holder: BlocksViewHolder) {
        holder.release()
    }

    override fun getItemCount(): Int = items.size + 1

}