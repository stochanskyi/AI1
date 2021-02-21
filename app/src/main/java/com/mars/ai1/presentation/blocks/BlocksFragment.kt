package com.mars.ai1.presentation.blocks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mars.ai1.R
import com.mars.ai1.databinding.FragmentBlocksBinding
import com.mars.ai1.presentation.blocks.adapter.BlocksAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlocksFragment : Fragment(R.layout.fragment_blocks) {

    private val viewModel: BlocksViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentBlocksBinding.bind(view).run {
            initViews(this)
            initObservers(this)
        }
    }

    private fun initViews(binding: FragmentBlocksBinding) {
        binding.blocksRecyclerView.apply {
            adapter = BlocksAdapter(
                {}, {}, {}, {}
            )
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initObservers(binding: FragmentBlocksBinding) {
        viewModel.blocksLiveData.observe(viewLifecycleOwner) {
            binding.blocksRecyclerView.adapterAction { setItems(it) }
        }
    }

    private fun RecyclerView.adapterAction(action: BlocksAdapter.() -> Unit) {
        (adapter as? BlocksAdapter)?.action()
    }
}