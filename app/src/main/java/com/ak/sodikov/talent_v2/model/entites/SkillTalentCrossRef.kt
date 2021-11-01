package com.ak.sodikov.talent_v2.model.entites

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import org.jetbrains.annotations.NotNull

@Entity (
    primaryKeys = ["skillId", "talentId"], tableName = "skillTalentCross")
data class SkillTalentCrossRef (

    @ColumnInfo (name = "skillId")
    val skillId : Int,

    @ColumnInfo (name = "talentId")
     val talentId : Int
  )

