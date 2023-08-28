package com.piotrpytlik.toyotainterview.presentation.navigation

sealed class Screen(val route: String) {
    object CharacterListScreen: Screen("char_list_screen")
    object CharacterScreen: Screen("single_char_screen")
}
