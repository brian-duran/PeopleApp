package brian.duran.listapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import brian.duran.listapp.R
import brian.duran.listapp.domain.model.User
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun UserContent(
    padding: PaddingValues,
    users: List<User>,
    navigateToEditScreen: (userId: Int) -> Unit,
    onUserDelete: (User) -> Unit,
    isLoading: Boolean
){
    LazyColumn(modifier = Modifier.padding(padding)) {
        var itemCount = users.size
        if (isLoading) itemCount++

        items(count = itemCount) { index ->
            var auxIndex = index;
            if (isLoading) {
                if (auxIndex == 0)
                    return@items LoadingCard()
                auxIndex--
            }
            val user = users[auxIndex]

            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.elevatedCardElevation(1.dp),
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .fillMaxWidth()
                    .clickable {  navigateToEditScreen(user.id!!)}
            ) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(
                                LocalContext.current
                            ).data(data = user.picture)
                                .apply(block = fun ImageRequest.Builder.() {
                                    placeholder(R.drawable.placeholder)
                                    error(R.drawable.placeholder)
                                }).build()
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight
                    )
                    Spacer()
                    Column(
                        Modifier.weight(1f),
                    ) {
                        Text("${user.name} ${user.lastname}")
                        Text(user.city)
                    }
                    Spacer()
                    IconButton(onClick = {
                        onUserDelete(user)
                    }) {
                        Icon(Icons.Filled.Delete, "Remove")
                    }
                }
            }
        }
    }
}