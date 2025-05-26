package brian.duran.listapp.presentation.edit.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import brian.duran.listapp.utils.Constants.EDIT_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateUserTopBar(
    navigateHomeScreen: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(EDIT_SCREEN)
        },
        navigationIcon = {
            IconButton(onClick = { navigateHomeScreen() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Regresar a la pantalla principal")
            }
        }
    )
}