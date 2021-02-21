package com.mars.ai1.presentation.testing.adapter.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.mars.ai1.data.repository.questions.models.AnswerOption
import com.mars.ai1.data.repository.questions.models.Question
import com.mars.ai1.databinding.ViewHolderQuestionBinding

class QuestionViewHolder private constructor(private val binding: ViewHolderQuestionBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): QuestionViewHolder {
            return QuestionViewHolder(
                ViewHolderQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    fun bind(
        model: Question,
        answerChangedBlock: (Long, Long) -> Unit
    ) {
        binding.questionTextView.text = model.content
        model.answerOptions.forEach {
            addAnswerOption(it)
        }
        binding.answersGroup.setOnCheckedChangeListener { group, checkedId ->
            answerChangedBlock(model.id, group.findViewById<RadioButton>(checkedId).tag as Long)
        }
    }

    private fun addAnswerOption(answerOption: AnswerOption) {
        binding.answersGroup.addView(
            RadioButton(itemView.context).apply {
                text = answerOption.name
                tag = answerOption.answerId
            }
        )
    }

    fun release() {
        binding.answersGroup.apply {
            setOnCheckedChangeListener(null)
            removeAllViews()
        }
    }
}