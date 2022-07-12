package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.quizapp.modals.QuizModal
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var position : Int = 0
    private var questionAttempted = 0
    private var currentScore = 0
    val list = arrayListOf<QuizModal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getQuizQuestions(list)
        setData(position)

        BtnOption1.setOnClickListener (object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (list[position].answer.trim() == list[position].option1.trim()){
                    currentScore++
                }
                questionAttempted++
                position = Random().nextInt(list.size)
                setData(position)
            }
        })
        BtnOption2.setOnClickListener (object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (list[position].answer.trim() == list[position].option2.trim()){
                    currentScore++
                }
                questionAttempted++
                position = Random().nextInt(list.size)
                setData(position)
            }
        })
        BtnOption3.setOnClickListener (object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (list[position].answer.trim() == list[position].option3.trim()){
                    currentScore++
                }
                questionAttempted++
                position = Random().nextInt(list.size)
                setData(position)
            }
        })
        BtnOption4.setOnClickListener (object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (list[position].answer.trim() == list[position].option4.trim()){
                    currentScore++
                }
                questionAttempted++
                position = Random().nextInt(list.size)
                setData(position)
            }
        })

        nextBtn.setOnClickListener{
            questionAttempted++
            position = Random().nextInt(list.size)
            setData(position)
        }
    }

    private fun setData(position: Int) {
        totalTv.text = questionAttempted.toString()
        if (questionAttempted == list.size) {
            completeTv.isVisible = true
            scoreTv.text = currentScore.toString()
            scoreTv.isVisible = true
            BtnOption1.isClickable = false
            BtnOption2.isClickable = false
            BtnOption3.isClickable = false
            BtnOption4.isClickable = false
            nextBtn.isClickable = false
        } else {
            question.text = list[position].question
            BtnOption1.text = list[position].option1
            BtnOption2.text = list[position].option2
            BtnOption3.text = list[position].option3
            BtnOption4.text = list[position].option4
        }
    }

    private fun getQuizQuestions(list: ArrayList<QuizModal>) {
        list.add(QuizModal(
            "How are you?",
            "Good",
            "Better",
            "Best",
            "Never like this before",
            "Never like this before"
        ))
        list.add(QuizModal(
            "Where are you going?",
            "Mountains",
            "Friend's House",
            "Office",
            "Home",
            "Mountains"
        ))
        list.add(QuizModal(
            "Who are you professionally",
            "Doctor",
            "Lawyer",
            "Engineer",
            "Android App Developer :)",
            "Android App Developer :)"
        ))
    }


}