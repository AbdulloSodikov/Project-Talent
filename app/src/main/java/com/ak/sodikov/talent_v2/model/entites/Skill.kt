package com.ak.sodikov.talent_v2.model.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "skills")

data class Skill (
    @PrimaryKey(autoGenerate = false)
    val skillId : Int,

    @ColumnInfo (name = "skillName")
    val skillName: String
        )
