package brian.duran.listapp.domain.model

import brian.duran.listapp.domain.model.dto.UserLocationDto
import brian.duran.listapp.domain.model.dto.UserNameDto
import brian.duran.listapp.domain.model.dto.UserPictureDto

data class ApiResponse(
    val results: List<Results> = emptyList()
)

data class Results(
    val name: UserNameDto?,
    val location: UserLocationDto?,
    val picture: UserPictureDto?
)
