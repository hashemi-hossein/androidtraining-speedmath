package ara.hossein.androidtraining.speedmath.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var firstNumber by remember { mutableIntStateOf(1) }
    var secondNumber by remember { mutableIntStateOf(1) }
    var userInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    fun generateNumbers() {
        firstNumber = Random(seed = System.currentTimeMillis()).nextInt(1, 10)
        secondNumber = Random(seed = System.currentTimeMillis()).nextInt(1, 10)
    }

    fun checkAnswer(userInput: String): Boolean {
        val correctAnswer = firstNumber + secondNumber
        return userInput.toIntOrNull() == correctAnswer
    }

    LaunchedEffect(Unit) {
        generateNumbers()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.align(Alignment.Center),
        ) {
            Text(
                text = "$firstNumber + $secondNumber",
                style = MaterialTheme.typography.headlineMedium,
            )
            OutlinedTextField(
                value = userInput,
                onValueChange = { userInput = it },
                label = { Text("Your Answer") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Button(onClick = {
                if (checkAnswer(userInput)) {
                    result = "Correct!"
                    generateNumbers()
                    userInput = ""
                } else {
                    result = "Incorrect, try again."
                }
            }) {
                Text("Submit")
            }
            Text(text = result, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
