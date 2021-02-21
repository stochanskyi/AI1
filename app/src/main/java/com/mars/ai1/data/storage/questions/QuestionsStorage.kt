package com.mars.ai1.data.storage.questions

import com.mars.ai1.data.storage.questions.models.AnswerOptionDataModel
import com.mars.ai1.data.storage.questions.models.QuestionBlockDataModel
import com.mars.ai1.data.storage.questions.models.QuestionDataModel
import javax.inject.Inject

interface QuestionsStorage {
    val questionBlocks: List<QuestionBlockDataModel>
}

class QuestionsStorageImpl @Inject constructor() : QuestionsStorage {
    override val questionBlocks: List<QuestionBlockDataModel> = listOf(
        QuestionBlockDataModel(
            1,
            "Novice",
            listOf(
                QuestionDataModel(
                    1,
                    "Переживаєте за успіх в роботі?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Сильно",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Не дуже",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Спокійний",
                            2
                        )
                    )
                ),
                QuestionDataModel(
                    2,
                    "Прагнете досягти швидко результату?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Поступово",
                            2
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Якомога швидше",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Дуже",
                            5
                        )
                    )
                ),
                QuestionDataModel(
                    3,
                    "Легко попадаєте в тупик при проблемах в роботі?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Неодмінно",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Поступово",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Зрідка",
                            2
                        )
                    )
                ),
                QuestionDataModel(
                    4,
                    "Чи потрібен чіткий алгоритм для вирішення задач?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "В окремих випадках",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Не потрібен",
                            2
                        )
                    )
                )
            )
        ),
        QuestionBlockDataModel(
            2,
            "Advanced beginner",
            listOf(
                QuestionDataModel(
                    5,
                    "Чи використовуєте власний досвід при вирішенні задач?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Зрідка",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Частково",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Ні",
                            2
                        )
                    )
                ),
                QuestionDataModel(
                    6,
                    "Чи користуєтесь фіксованими правилами  для вирішення задач?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            2
                        ),
                        AnswerOptionDataModel(
                            2,
                            "В окремих випадках",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Не потрібні",
                            5
                        )
                    )
                ),
                QuestionDataModel(
                    7,
                    "•\tЧи відчуваєте ви загальний контекст вирішення задачі?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            2
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Частково",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "В окремих випадках",
                            5
                        )
                    )
                )
            )
        ),
        QuestionBlockDataModel(
            3,
            "Competent",
            listOf(
                QuestionDataModel(
                    8,
                    "Чи можете ви побудувати модель вирішуваної задачі?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Не повністю",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "В окремих випадках",
                            2
                        )
                    )
                ),
                QuestionDataModel(
                    9,
                    "Чи вистачає вам ініціативи при вирішенні задач?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Зрідка",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Потрібне натхнення",
                            2
                        )
                    )
                ),
                QuestionDataModel(
                    10,
                    "Чи можете вирішувати проблеми, з якими ще не стикались?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            2
                        ),
                        AnswerOptionDataModel(
                            2,
                            "В окремих випадках",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Ні",
                            5
                        )
                    )
                )
            )
        ),
        QuestionBlockDataModel(
            4,
            "Proficient",
            listOf(
                QuestionDataModel(
                    11,
                    "Чи необхідний вам весь контекст задачі?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "В окремих деталях",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "В загальному",
                            2
                        )
                    )
                ),
                QuestionDataModel(
                    12,
                    "Чи переглядаєте ви свої наміри до вирішення задачі?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Зрідка",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Коли є потреба",
                            2
                        )
                    )
                ),
                QuestionDataModel(
                    13,
                    "Чи здатні  ви  навчатись у інших?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Зрідка",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Коли є потреба",
                            2
                        )
                    )
                )
            )
        ),
        QuestionBlockDataModel(
            5,
            "Expert",
            listOf(
                QuestionDataModel(
                    14,
                    "Чи обираєте ви нові методи своєї роботи?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Вибірково",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Вистачає досвіду",
                            2
                        )
                    )
                ),
                QuestionDataModel(
                    15,
                    "Чи допомагає власна інтуїція при вирішенні задач?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Так",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Частково",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "При емоційному напруженні",
                            2
                        )
                    )
                ),
                QuestionDataModel(
                    16,
                    "Чи застовуєте рішення задач за аналогією?",
                    listOf(
                        AnswerOptionDataModel(
                            1,
                            "Часто",
                            5
                        ),
                        AnswerOptionDataModel(
                            2,
                            "Зрідка",
                            3
                        ),
                        AnswerOptionDataModel(
                            3,
                            "Тільки власний варіант",
                            2
                        )
                    )
                )
            )
        )
    )
}
