package brian.duran.listapp.data.network

import brian.duran.listapp.domain.model.ApiResponse
import retrofit2.http.GET

interface UserApi {

    @GET("?inc=name")
    suspend fun getUserName(): ApiResponse

    @GET("?inc=location")
    suspend fun getUserLocation(): ApiResponse

    @GET("?inc=picture")
    suspend fun getUserPicture(): ApiResponse
}