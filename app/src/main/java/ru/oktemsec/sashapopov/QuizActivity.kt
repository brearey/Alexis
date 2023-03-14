package ru.oktemsec.sashapopov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {

    private val TAG = QuizActivity::class.java.simpleName
    private val arrayOfAnswers = mutableListOf<String>()

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
            arrayOfAnswers.add("Да")
            questionTextView.text = nextQuestion(indexOfQuestion)
        }
        negativeButton.setOnClickListener {
            indexOfQuestion++
            arrayOfAnswers.add("Нет")
            questionTextView.text = nextQuestion(indexOfQuestion)
        }
        difficultButton.setOnClickListener {
            indexOfQuestion++
            arrayOfAnswers.add("Затрудняюсь")
            questionTextView.text = nextQuestion(indexOfQuestion)
        }
    }

    private fun nextQuestion(index:Int): String {

        Log.d("brearey", arrayOfAnswers.toString())
        Toast.makeText(this, "Ваши ответы: ${arrayOfAnswers}", Toast.LENGTH_SHORT).show()

        val questionRepository = QuestionRepository()
        return if (index < questionRepository.questions.size) questionRepository.questions[index]
        else {
            positiveButton.isEnabled = false
            negativeButton.isEnabled = false
            difficultButton.isEnabled = false
            startActivity(Intent(this, MapActivity::class.java))
            return "no questions"
        }
    }
}

class QuestionRepository {
    val questions = arrayOf (
        "Головные боли, головокружения, болевые ощущения в ногах при ходьбе, боли в груди?",
        "Боль в позвоночнике?",
        "Бледность лица, посинение губ, мочек ушей, ног?",
        "Повышенная утомляемость, слабость, дрожь в руках?",
    )
}