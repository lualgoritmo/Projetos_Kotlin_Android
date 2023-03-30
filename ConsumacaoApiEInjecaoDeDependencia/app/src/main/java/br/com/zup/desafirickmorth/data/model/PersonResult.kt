package br.com.zup.desafirickmorth.data.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Person")
data class PersonResult(
    @SerializedName("gender")
    var gender: String,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("species")
    var species: String,
    @SerializedName("status")
    var status: String,
):Parcelable