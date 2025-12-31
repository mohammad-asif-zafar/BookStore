package com.hathway.bookstore.data

data class QuizOption(
    val id: String,
    val text: String,
    val isCorrect: Boolean = false
)

data class QuizQuestion(
    val title: String,
    val meta: String,
    val question: String,
    val options: List<QuizOption>,
    val selectedId: String? = null
)
