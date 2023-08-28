package com.piotrpytlik.toyotainterview.presentation.characters.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.piotrpytlik.toyotainterview.presentation.characters.viewmodel.CharacterListViewModel

@Composable
fun CharacterListScreen(navController: NavController) {
    val viewModel: CharacterListViewModel = hiltViewModel<CharacterListViewModel>()
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        if (state.loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.characterList) { item ->
                Row {
                    Text(item.name, color = Color.Magenta)
                    Spacer(modifier = Modifier.width(10.dp))
                    AsyncImage(modifier = Modifier.size(40.dp), model = item.imageUrl, contentDescription = "${item.name}")
                }
            }
        }
    }
}