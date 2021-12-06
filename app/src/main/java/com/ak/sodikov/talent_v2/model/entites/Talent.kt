package com.ak.sodikov.talent_v2.model.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

import java.io.Serializable

@Entity(
    tableName = "talent",
    /* foreignKeys = [ForeignKey(
         entity = Profession::class,
         parentColumns = ["professionName"],
         childColumns = ["professionNameInTalent"]
     ),

         ForeignKey(
             entity = City::class,
             parentColumns = ["cityName"],
             childColumns = ["cityNameInTalent"]
         )]*/
)
data class Talent(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val talentId: Int = 0,

    @SerializedName("first_name")
    val talentSurname: String?,

    @SerializedName("last_name")
    val talentName: String?,

    @SerializedName("email")
    val email: String?,

    @SerializedName("avatar")
    val urlAvatar: String?,

    @SerializedName("username")
    val workState: String?,

    val info: String?,
    val education: String,

    @ColumnInfo(name = "professionNameInTalent")
    val professionNameInTalent: String?, // внешний ключ

    @ColumnInfo(name = "cityNameInTalent")
    @SerializedName("city")
    val cityNameInTalent: String?, // внешний ключ

///
) : Serializable

