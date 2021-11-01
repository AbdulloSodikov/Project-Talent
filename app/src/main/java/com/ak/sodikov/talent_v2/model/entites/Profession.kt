package com.ak.sodikov.talent_v2.model.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "profession")

data class Profession (
    @PrimaryKey (autoGenerate = false)
    @ColumnInfo (name = "professionId")
    val professionId : Int,

    @ColumnInfo (name = "professionName")
    val professionName : String

    )