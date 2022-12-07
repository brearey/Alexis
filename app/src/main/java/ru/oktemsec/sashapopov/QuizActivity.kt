package ru.oktemsec.sashapopov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val questionTextView: TextView = findViewById(R.id.question_tv)
        val positiveButton: Button = findViewById(R.id.positive_button)
        val negativeButton: Button = findViewById(R.id.negative_button)
        val difficultButton: Button = findViewById(R.id.difficult_button)

        var indexOfQuestion = 0

        positiveButton.setOnClickListener {
            indexOfQuestion++
            questionTextView.text = nextQuestion(indexOfQuestion)
        }
        negativeButton.setOnClickListener {
            indexOfQuestion++
            questionTextView.text = nextQuestion(indexOfQuestion)
        }
        difficultButton.setOnClickListener {
            indexOfQuestion++
            questionTextView.text = nextQuestion(indexOfQuestion)
        }
    }

    private fun nextQuestion(index:Int): String {
        val questionRepository = QuestionRepository()
        return if (index < questionRepository.questions.size) questionRepository.questions[index]
        else "no questions"
    }
}

class QuestionRepository() {
    val questions = arrayOf<String>(
        "1 Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
        "2 Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
        "3 Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
    )
}