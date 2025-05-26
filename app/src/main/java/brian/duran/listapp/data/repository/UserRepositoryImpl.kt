package brian.duran.listapp.data.repository

import androidx.lifecycle.LiveData
import brian.duran.listapp.data.local.UserDao
import brian.duran.listapp.data.network.UserApi
import brian.duran.listapp.domain.model.User
import brian.duran.listapp.domain.repository.UserRepository
import brian.duran.listapp.utils.Constants.TIME_DELAY
import kotlinx.coroutines.delay
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val userDao: UserDao
): UserRepository {
    override fun getUsers(): LiveData<List<User>> = userDao.getUsers()

    override suspend fun insertUser(): User {
        delay(TIME_DELAY)

        val name = userApi.getUserName().results[0].name!!
        val location = userApi.getUserLocation().results[0].location!!
        val picture = userApi.getUserPicture().results[0].picture!!

        val user = User(null,name.first, name.last, location.city, picture.thumbnail)

        userDao.insertUser(user)
        return user
    }

    override suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    override suspend fun getUserById(userId: Int): User? {
        return userDao.getUserById(userId)
    }
}