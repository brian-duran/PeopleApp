package brian.duran.listapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import brian.duran.listapp.domain.model.User
import brian.duran.listapp.utils.Constants.USER_TABLE_NAME

@Dao
interface UserDao {
    @Query("SELECT * FROM $USER_TABLE_NAME")
    fun getUsers(): LiveData<List<User>>

    @Query("SELECT * FROM $USER_TABLE_NAME WHERE id = :userId")
    fun getUserById(userId: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}