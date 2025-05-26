package brian.duran.listapp.presentation.edit

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import brian.duran.listapp.presentation.edit.components.UpdateUserTopBar
import brian.duran.listapp.presentation.edit.components.UserEditContent
import brian.duran.listapp.presentation.home.UserViewModel

@Composable
fun EditScreen(
    viewModel: UserViewModel = hiltViewModel(),
    userId: Int,
    navigateBack: () -> Unit
){
    LaunchedEffect(Unit){
        viewModel.getUserById(userId)
    }
    Scaffold(
        topBar = {
            UpdateUserTopBar(
                navigateHomeScreen = navigateBack
            )
        },
        content = { padding ->
            UserEditContent(
                padding = padding,
                user = viewModel.user,
                onUserUpdate = { user ->
                    viewModel.updateUser(user)
                },
                onUserNameUpdate = { name ->
                    viewModel.updateName(name)
                },
                onUserLastnameUpdate = { lastname ->
                    viewModel.updateLastname(lastname)
                },
                onUserCityUpdate = { city ->
                    viewModel.updateCity(city)
                },
                navigateHomeScreen = navigateBack
            )
        }
    )
}