package brian.duran.listapp.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import brian.duran.listapp.domain.model.User
import brian.duran.listapp.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    var user by mutableStateOf(User(
        name = "",
        lastname = "",
        city = "",
        picture = ""
    ))

    val users by lazy {
        userRepository.getUsers()
    }

    private val _isLoading by lazy {
        MutableLiveData<Boolean>(false)
    }

    val isLoading: LiveData<Boolean> get() =_isLoading

    fun addUser() {
        if (_isLoading.value == false) {
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                userRepository.insertUser()
                _isLoading.postValue(false)

            }
        }
    }

    fun deleteUser(toDelete: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(toDelete)
        }
    }

    fun getUserById(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = userRepository.getUserById(userId)
            withContext(Dispatchers.Main) {
                user = result!!
            }
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)
        }
    }

    fun updateName(name: String){
        user = user.copy(
            name = name
        )
    }
    fun updateLastname(lastname: String){
        user = user.copy(
            lastname = lastname
        )
    }
    fun updateCity(city: String){
        user = user.copy(
            city = city
        )
    }
    fun updatePicture(picture: String){
        user = user.copy(
            picture = picture
        )
    }
}