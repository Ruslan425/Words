package ru.romazanov.words.ui.theme.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.romazanov.words.MainViewModel
import ru.romazanov.words.data.Word
import ru.romazanov.words.ui.theme.defaultComponents.DefWordCard


@Composable
fun WordListScreen(
    viewModel: MainViewModel
) {


    val list = viewModel.wordLIst.observeAsState(initial = listOf()).value

    var text by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()



    Scaffold() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                OutlinedTextField(
                    label = { Text("Текст") },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    value = text, onValueChange = { text = it },
                )
                Button(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    onClick = {

                            viewModel.addWord(Word(word = text))

                        text = ""
                }) {
                    Text("Нажими на меня")
                }
            }
            items(list) { word ->
                DefWordCard(word = word, onClick = {
                    viewModel.deleteWord(word)
                })
            }
        }
    }
}