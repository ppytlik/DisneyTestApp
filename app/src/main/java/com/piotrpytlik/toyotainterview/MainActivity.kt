package com.piotrpytlik.toyotainterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.piotrpytlik.toyotainterview.presentation.characters.ui.CharacterListScreen
import com.piotrpytlik.toyotainterview.presentation.characters.viewmodel.CharacterListViewModel
import com.piotrpytlik.toyotainterview.presentation.navigation.Screen
import com.piotrpytlik.toyotainterview.ui.theme.ToyotaInterviewTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToyotaInterviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = Screen.CharacterListScreen.route) {
                        composable(Screen.CharacterListScreen.route) {
                            CharacterListScreen(navController)
                        }
                    }
                }
            }
        }
    }
}