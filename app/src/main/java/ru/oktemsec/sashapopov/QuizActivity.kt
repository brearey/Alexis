package ru.oktemsec.sashapopov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class QuizActivity : AppCompatActivity() {

    private val TAG = QuizActivity::class.java.simpleName
    private val arrayOfAnswers = mutableListOf<Int>()

    private lateinit var questionTextView:TextView
    private lateinit var positiveButton:Button
    private lateinit var negativeButton:Button
    private lateinit var difficultButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionTextView = findViewById(R.id.question_tv)
        positiveButton = findViewById(R.id.positive_button)
        negativeButton = findViewById(R.id.negative_button)
        difficultButton = findViewById(R.id.difficult_button)

        var indexOfQuestion = 0

        positiveButton.setOnClickListener {
            indexOfQuestion++
            questionTextView.text = nextQuestion(indexOfQuestion)
            arrayOfAnswers.add(0)
        }
        negativeButton.setOnClickListener {
            indexOfQuestion++
            questionTextView.text = nextQuestion(indexOfQuestion)
            arrayOfAnswers.add(1)
        }
        difficultButton.setOnClickListener {
            indexOfQuestion++
            questionTextView.text = nextQuestion(indexOfQuestion)
            arrayOfAnswers.add(2)
        }
    }

    private fun nextQuestion(index:Int): String {
        val questionRepository = QuestionRepository()
        return if (index < questionRepository.questions.size) questionRepository.questions[index]
        else {
            positiveButton.isEnabled = false
            negativeButton.isEnabled = false
            difficultButton.isEnabled = false
            Log.d(TAG, arrayOfAnswers.toString())
            return "no questions"
        }
    }
}

class QuestionRepository {
    val questions = arrayOf (
        "1 Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
        "2 Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
        "3 Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
        "4 Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
        "5 Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
        "6 Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
    )
}