package com.hathway.bookstore.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hathway.bookstore.data.QuizOption
import com.hathway.bookstore.data.QuizQuestion

@Composable
fun QuizScreen() {

    val quiz = remember {
        mutableStateOf(
            QuizQuestion(
                title = "Quiz Practice",
                meta = "19 min • 02/10 points",
                question = "2. Which of the following is an example of a \"call to action\" in UX design?",
                options = listOf(
                    QuizOption("a", "a. A \"Buy Now\" button", true),
                    QuizOption("b", "b. An image carousel"),
                    QuizOption("c", "c. An image carousel")
                )
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        QuizCard(
            quiz = quiz.value, onOptionSelected = {
                quiz.value = quiz.value.copy(selectedId = it)
            })

        Spacer(modifier = Modifier.weight(1f))

        QuizBottomActions(onBack = { println("Back") }, onNext = { println("Next") })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQuizScreen() {
    QuizScreen()
}