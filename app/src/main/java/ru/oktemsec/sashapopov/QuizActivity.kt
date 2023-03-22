package ru.oktemsec.sashapopov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class QuizActivity : AppCompatActivity() {

    // object of Question Repo
    private val questionRepository = QuestionRepository()

    private lateinit var questionTextView:TextView
    private lateinit var positiveButton:Button
    private lateinit var negativeButton:Button
    private lateinit var difficultButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        //Get intent type of pain zone
        val painZone = intent.getStringExtra("painZone")!!

        questionTextView = findViewById(R.id.question_tv)
        positiveButton = findViewById(R.id.positive_button)
        negativeButton = findViewById(R.id.negative_button)
        difficultButton = findViewById(R.id.difficult_button)

        var indexOfQuestion = 0

        //generate first question
        val oneQuestion = nextQuestion(indexOfQuestion, painZone)
        questionTextView.text = oneQuestion.questionText

        positiveButton.setOnClickListener {
            if (indexOfQuestion == 0) {
                questionTextView.text = nextQuestion(indexOfQuestion, painZone).questionText
            } else {
                val oneQuestion = nextQuestion(indexOfQuestion, painZone)

                questionTextView.text = oneQuestion.questionText
            }
            indexOfQuestion++
        }
        negativeButton.setOnClickListener {
            if (indexOfQuestion == 0) {
                questionTextView.text = nextQuestion(indexOfQuestion, painZone).questionText
            } else {
                questionTextView.text = nextQuestion(indexOfQuestion, painZone).questionText
            }
            indexOfQuestion++
        }
        difficultButton.setOnClickListener {
            indexOfQuestion++
            questionTextView.text = nextQuestion(indexOfQuestion, painZone).questionText
        }
    }

    private fun nextQuestion(index:Int, painZone:String): SimpleQuestion {
        val questions = emptyList<SimpleQuestion>().toMutableList()

        if (painZone == "meningit") {
                questionRepository.meningitSimpleQuestions.forEach {
                questions += it
            }
        } else if (painZone == "gastrit") {
            questionRepository.gastritSimpleQuestions.forEach {
                questions += it
            }
        }

        return if (index < questions.size) questions[index]
        else {
            positiveButton.isEnabled = false
            negativeButton.isEnabled = false
            difficultButton.isEnabled = false

            if (painZone == "meningit") {
                startActivity(Intent(this, MeningitActivity::class.java))
            } else if (painZone == "gastrit") {
                startActivity(Intent(this, GastritActivity::class.java))
            }

            return SimpleQuestion(questionText = "Вопросы закончились")
        }
    }
}