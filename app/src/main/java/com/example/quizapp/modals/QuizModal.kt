package com.example.quizapp.modals

data class QuizModal(
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    var answer: String
    )