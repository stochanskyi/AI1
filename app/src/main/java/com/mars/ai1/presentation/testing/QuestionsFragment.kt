package com.mars.ai1.presentation.testing

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mars.ai1.R
import com.mars.ai1.databinding.FragmentQuestionsBinding
import com.mars.ai1.presentation.testing.adapter.QuestionsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionsFragment : Fragment(R.layout.fragment_questions) {
    private val args: QuestionsFragmentArgs by navArgs()
    private val viewModel: QuestionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setup(args.block)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentQuestionsBinding.bind(view).run {
            initViews(this)
            initListeners(this)
            initObservers(this)
        }
    }

    private fun initViews(binding: FragmentQuestionsBinding) {
        binding.questionsRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = QuestionsAdapter { questionId, answerId ->
                viewModel.setQuestionAnswer(questionId, answerId)
            }
        }
    }

    private fun initListeners(binding: FragmentQuestionsBinding) {
        binding.saveButton.setOnClickListener { viewModel.saveAnswers() }
    }

    private fun initObservers(binding: FragmentQuestionsBinding) {
        viewModel.blockNameLiveData.observe(viewLifecycleOwner) {
            binding.textBlockName.text = it
        }
        viewModel.questionsLiveData.observe(viewLifecycleOwner) {
            binding.questionsRecycler.adapterAction { setItems(it) }
        }
        viewModel.isSaveEnabled.observe(viewLifecycleOwner) {
            binding.saveButton.isVisible = it
        }
    }

    private fun RecyclerView.adapterAction(action: QuestionsAdapter.() -> Unit) {
        (adapter as QuestionsAdapter).action()
    }
}