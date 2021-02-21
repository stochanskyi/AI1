package com.mars.ai1.presentation.testing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mars.ai1.R
import com.mars.ai1.data.repository.questions.QuestionsRepository
import com.mars.ai1.databinding.FragmentQuestionsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuestionsFragment : Fragment(R.layout.fragment_questions) {

    @Inject
    lateinit var questions: QuestionsRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentQuestionsBinding.bind(view).run {
            initViews(this)
        }
    }

    private fun initViews(binding: FragmentQuestionsBinding) {
    }
}