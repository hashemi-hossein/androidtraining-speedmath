package ara.hossein.androidtraining.speedmath.screen

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class HomeViewModel : ViewModel() {
    var firstNumber = mutableIntStateOf(1)
    var secondNumber = mutableIntStateOf(1)
    var userInput = mutableStateOf("")
    var result = mutableStateOf("")


    fun generateNumbers() {
        firstNumber.value = Random(seed = System.currentTimeMillis()).nextInt(1, 10)
        secondNumber.value = Random(seed = System.currentTimeMillis()).nextInt(1, 10)
    }

    fun checkAnswer(userInput: String): Boolean {
        val correctAnswer = firstNumber.value + secondNumber.value
        return userInput.toIntOrNull() == correctAnswer
    }

    init {
        generateNumbers()
    }

}