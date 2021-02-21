package com.mars.ai1.presentation.testing.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mars.ai1.data.repository.questions.models.Question
import com.mars.ai1.presentation.testing.adapter.viewholders.QuestionViewHolder

class QuestionsAdapter(
    private val answerChangedBlock: (questionId: Long, answerId: Long) -> Unit
): RecyclerView.Adapter<QuestionViewHolder>() {

    private val items: MutableList<Question> = mutableListOf()

    fun addItems(items: List<Question>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(items[position], answerChangedBlock)
    }

    override fun onViewRecycled(holder: QuestionViewHolder) {
        holder.release()
    }

    override fun getItemCount(): Int = items.size

}