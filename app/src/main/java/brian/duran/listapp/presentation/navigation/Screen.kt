package brian.duran.listapp.presentation.navigation

import brian.duran.listapp.utils.Constants.EDIT_SCREEN
import brian.duran.listapp.utils.Constants.HOME_SCREEN

sealed class Screen (val route: String) {
    object HomeScreen: Screen(HOME_SCREEN)
    object EditScreen: Screen(EDIT_SCREEN)
}