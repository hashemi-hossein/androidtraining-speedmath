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
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val viewModel: HomeViewModel = viewModel()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.align(Alignment.Center),
        ) {
            Text(
                text = "${viewModel.firstNumber.value} + ${viewModel.secondNumber.value}",
                style = MaterialTheme.typography.headlineMedium,
            )
            OutlinedTextField(
                value = viewModel.userInput.value,
                onValueChange = { viewModel.userInput.value = it },
                label = { Text("Your Answer") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Button(onClick = {
                if (viewModel.checkAnswer(viewModel.userInput.value)) {
                    viewModel.result.value = "Correct!"
                    viewModel.generateNumbers()
                    viewModel.userInput.value = ""
                } else {
                    viewModel.result.value = "Incorrect, try again."
                }
            }) {
                Text("Submit")
            }
            Text(text = viewModel.result.value, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
