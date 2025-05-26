package brian.duran.listapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import brian.duran.listapp.presentation.edit.EditScreen
import brian.duran.listapp.presentation.home.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navigateToEditScreen = { userId ->
                    navController.navigate("${Screen.EditScreen.route}/${userId}")
                }
            )
        }

        composable(
            route = "${Screen.EditScreen.route}/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ){
            val userId = it.arguments?.getInt("userId") ?: 0
            EditScreen(
                userId = userId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}