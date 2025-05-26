package brian.duran.listapp.presentation.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import brian.duran.listapp.presentation.home.components.UserContent
import brian.duran.listapp.utils.Constants.HOME_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: UserViewModel = hiltViewModel(),
    navigateToEditScreen: (userId: Int) -> Unit
){
    val users by viewModel.users.observeAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.observeAsState(initial = false)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = HOME_SCREEN) },
                actions = {
                    IconButton(onClick = { viewModel.addUser() }) {
                        Icon(Icons.Filled.Add, "Add")
                    }
                }
            )

        }
        ,
        content = { paddingValues ->
            UserContent(
                padding = paddingValues,
                users = users,
                navigateToEditScreen = navigateToEditScreen,
                onUserDelete = { viewModel.deleteUser(it) },
                isLoading = isLoading
            )
        }
    )
}

