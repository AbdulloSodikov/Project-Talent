package com.ak.sodikov.talent_v2.model.entites

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "city")
data class City  (
    @PrimaryKey (autoGenerate = false)
    val cityId : Int,
    val cityName: String
  )