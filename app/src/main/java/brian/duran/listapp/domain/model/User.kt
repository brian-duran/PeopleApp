package brian.duran.listapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import brian.duran.listapp.utils.Constants.USER_TABLE_NAME

@Entity(tableName = USER_TABLE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "lastname")
    val lastname: String,

    @ColumnInfo(name = "city")
    val city: String,

    @ColumnInfo(name = "picture")
    val picture: String
)
