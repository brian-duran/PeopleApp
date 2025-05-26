package brian.duran.listapp.presentation.edit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import brian.duran.listapp.domain.model.User

@Composable
fun UserEditContent(
    padding: PaddingValues,
    user: User,
    onUserUpdate: (User) -> Unit,
    onUserNameUpdate: (String) -> Unit,
    onUserLastnameUpdate: (String) -> Unit,
    onUserCityUpdate: (String) -> Unit,
    navigateHomeScreen: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = user.name,
            onValueChange = { name ->
                onUserNameUpdate(name)
            },
            placeholder = {
                Text("Escribe tu nombre")
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = user.lastname,
            onValueChange = { lastname->
                onUserLastnameUpdate(lastname)
            },
            placeholder = {
                Text("Escribe tu apellido")
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = user.city,
            onValueChange = { city ->
                onUserCityUpdate(city)
            },
            placeholder = {
                Text("Escribe tu ciudad")
            }
        )
        Button(
            onClick = {
                onUserUpdate(user)
                navigateHomeScreen()
            }
        ){
            Text("Actualizar")
        }
    }
}