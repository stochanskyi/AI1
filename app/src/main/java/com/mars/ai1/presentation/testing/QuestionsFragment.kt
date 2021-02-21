package com.mars.ai1.presentation.testing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mars.ai1.R
import com.mars.ai1.data.questions.QuestionRepository
import com.mars.ai1.data.questions.QuestionRepositoryImpl
import com.mars.ai1.databinding.FragmentQuestionsBinding
import dagger.hilt.android.AndroidEntryPoint
import layout.QuestionsAdapter
import javax.inject.Inject

@AndroidEntryPoint
class QuestionsFragment : Fragment(R.layout.fragment_questions) {

    @Inject
    lateinit var questions: QuestionRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentQuestionsBinding.bind(view).run {
            initViews(this)
        }
    }

    private fun initViews(binding: FragmentQuestionsBinding) {
        binding.questionsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = QuestionsAdapter { _, _ -> }.apply { addItems(questions.getQuestionBlocks().first().questions) }
        }
        binding.textBlockName.text = questions.getQuestionBlocks().first().name
    }
}