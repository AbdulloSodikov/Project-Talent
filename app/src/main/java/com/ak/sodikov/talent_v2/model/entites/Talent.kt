package com.ak.sodikov.talent_v2.model.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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

    val talentId: Int = 0,

    val talentSurname: String?,

     val talentName: String?,


    val email: String?,

    val urlAvatar: String?,

    val workState: String?,
    val info: String?,
    val education: String,

    @ColumnInfo(name = "professionNameInTalent")
    val professionNameInTalent: String?, // внешний ключ
    @ColumnInfo(name = "cityNameInTalent")
    val cityNameInTalent: String?, // внешний ключ

///
) : Serializable

