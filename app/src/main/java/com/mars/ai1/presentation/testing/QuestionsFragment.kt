package com.mars.ai1.presentation.testing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.mars.ai1.R
import com.mars.ai1.data.repository.questions.QuestionsRepository
import com.mars.ai1.databinding.FragmentQuestionsBinding
import com.mars.ai1.presentation.testing.adapter.QuestionsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuestionsFragment : Fragment(R.layout.fragment_questions) {

    private val args: QuestionsFragmentArgs by navArgs()

    @Inject
    lateinit var questions: QuestionsRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentQuestionsBinding.bind(view).run {
            initViews(this)
        }
    }

    private fun initViews(binding: FragmentQuestionsBinding) {
        binding.questionsRecycler.apply {
            adapter = QuestionsAdapter { _, _ -> }.apply {
                setItems(args.block.questions)
            }
            layoutManager = LinearLayoutManager(context)
        }
        binding.textBlockName.text = args.block.name
    }
}