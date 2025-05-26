package brian.duran.listapp.domain.repository

import androidx.lifecycle.LiveData
import brian.duran.listapp.domain.model.User

interface UserRepository {
    fun getUsers(): LiveData<List<User>>
    suspend fun insertUser(): User
    suspend fun updateUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun getUserById(userId: Int): User?
}