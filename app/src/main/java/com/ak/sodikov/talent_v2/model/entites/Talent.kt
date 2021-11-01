package com.ak.sodikov.talent_v2.model.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "talent")

data class Talent  (
    @PrimaryKey (autoGenerate = true) val talentId: Int = 0,
    @ColumnInfo val talentSurname : String = "",
    @ColumnInfo val talentName: String = "",
    val email : String = "",
    val workState : String = "",
    val info : String = "",
    val professionName: String = "", // внешний ключ
    val cityName : String = "", // внешний ключ

    )

