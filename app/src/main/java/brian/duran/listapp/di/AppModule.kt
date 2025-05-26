package brian.duran.listapp.di

import android.content.Context
import androidx.room.Room
import brian.duran.listapp.data.local.UserDB
import brian.duran.listapp.data.local.UserDao
import brian.duran.listapp.data.network.UserApi
import brian.duran.listapp.utils.Constants.BASE_URL
import brian.duran.listapp.utils.Constants.USER_DATABASE_NAME
import brian.duran.listapp.utils.Constants.USER_TABLE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDB {
        return Room.databaseBuilder(context, UserDB::class.java, USER_DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun userDao(db: UserDB): UserDao = db.userDao()
}