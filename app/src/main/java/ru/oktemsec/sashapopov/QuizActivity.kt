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

    // Agents
    private var agentsOfPainORVI: Int = 0
    private var agentsOfPainMeningit: Int = 0
    private var agentsOfPainORZ: Int = 0
    private var agentsOfPainNevralgia: Int = 0

    // High temp
    private var highTemp = false

    // object of Question Repo
    private val questionRepository = QuestionRepository()

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
            if (indexOfQuestion == 0) {
                highTemp = true
                questionTextView.text = nextQuestion(indexOfQuestion).questionText
            } else {
                val oneQuestion = nextQuestion(indexOfQuestion)
                agentsOfPainORVI += oneQuestion.painORVI
                agentsOfPainMeningit += oneQuestion.painMeningit
                agentsOfPainORZ += oneQuestion.painORZ
                agentsOfPainNevralgia += oneQuestion.painNevralgia

                questionTextView.text = oneQuestion.questionText

                // For debug
                Log.d("brearey", "Агенты ОРВИ: $agentsOfPainORVI")
                Log.d("brearey", "Агенты Менингита: $agentsOfPainMeningit")
                Log.d("brearey", "Агенты ОРЗ: $agentsOfPainORZ")
                Log.d("brearey", "Агенты Невралгии: $agentsOfPainNevralgia")
            }
            indexOfQuestion++
        }
        negativeButton.setOnClickListener {
            if (indexOfQuestion == 0) {
                highTemp = false
                questionTextView.text = nextQuestion(indexOfQuestion).questionText
            } else {
                questionTextView.text = nextQuestion(indexOfQuestion).questionText
            }
            indexOfQuestion++
        }
        difficultButton.setOnClickListener {
            indexOfQuestion++
            questionTextView.text = nextQuestion(indexOfQuestion).questionText
        }
    }

    private fun nextQuestion(index:Int): Question {
        val questions = emptyList<Question>().toMutableList()
        questionRepository.questions.forEach {
            if (it.highTemp == highTemp) questions += it
        }
        return if (index < questions.size) questions[index]
        else {
            positiveButton.isEnabled = false
            negativeButton.isEnabled = false
            difficultButton.isEnabled = false

            // TODO: startActivity
            val painsList = listOf("ОРВИ", "Менингит", "ОРЗ", "Невралгия")
            val agentsList = listOf(
                agentsOfPainORVI,
                agentsOfPainMeningit,
                agentsOfPainORZ,
                agentsOfPainNevralgia
            )
            val maxIdx = agentsList.indices.maxBy { agentsList[it] }
            Toast.makeText(this, "Ваш результат:\nБольшая вероятность что у вас: ${painsList[maxIdx]}", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MapActivity::class.java))

            return Question(questionText = "Вопросы закончились", painORVI = 0, painMeningit = 0, painORZ = 0, painNevralgia = 0, highTemp = false)
        }
    }
}