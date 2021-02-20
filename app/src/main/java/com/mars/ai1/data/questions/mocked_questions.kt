package com.mars.ai1.data.questions

import com.mars.ai1.data.questions.models.AnswerOption
import com.mars.ai1.data.questions.models.Question
import com.mars.ai1.data.questions.models.QuestionBlock


val mockedQuestions: List<QuestionBlock> = listOf(
    QuestionBlock(
        1,
        "Novice",
        listOf(
            Question(
                1,
                "Переживаєте за успіх в роботі?",
                listOf(
                    AnswerOption(
                        1,
                        "Сильно",
                        5
                    ),
                    AnswerOption(
                        2,
                        "Не дуже",
                        3
                    ),
                    AnswerOption(
                        3,
                        "Спокійний",
                        2
                    ),
                )
            ),
            //•	(поступово(2), якомога швидше(3), дуже(5));
            Question(
                2,
                "Прагнете досягти швидко результату?",
                listOf(
                    AnswerOption(
                        1,
                        "Поступово",
                        2
                    ),
                    AnswerOption(
                        2,
                        "якомога швидше",
                        3
                    ),
                    AnswerOption(
                        3,
                        "Дуже",
                        5
                    ),
                )
            )
        )
    )
)