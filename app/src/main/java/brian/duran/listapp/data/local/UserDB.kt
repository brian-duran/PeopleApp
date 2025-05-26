package brian.duran.listapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import brian.duran.listapp.domain.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDB: RoomDatabase() {
    abstract fun userDao(): UserDao
}