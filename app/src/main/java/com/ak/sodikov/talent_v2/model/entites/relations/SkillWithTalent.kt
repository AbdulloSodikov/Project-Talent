package com.ak.sodikov.talent_v2.model.entites.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.ak.sodikov.talent_v2.model.entites.Skill
import com.ak.sodikov.talent_v2.model.entites.SkillTalentCrossRef
import com.ak.sodikov.talent_v2.model.entites.Talent


data class SkillWithTalent (
    @Embedded
    val skill: Skill,
    @Relation (
        parentColumn = "skillId",
        entityColumn = "talentId",
        associateBy = Junction(SkillTalentCrossRef :: class)
    )
val talents:  List <Talent>

)
