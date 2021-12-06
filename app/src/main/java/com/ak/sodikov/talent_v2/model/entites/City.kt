package com.ak.sodikov.talent_v2.model.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "city")
data class City  (
    val cityId : Int,

    @PrimaryKey (autoGenerate = false)
    @ColumnInfo (name = "cityName")
    val cityName: String
  )