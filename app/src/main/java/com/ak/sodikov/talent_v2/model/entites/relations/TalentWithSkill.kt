package com.ak.sodikov.talent_v2.model.entites.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.ak.sodikov.talent_v2.model.entites.Skill
import com.ak.sodikov.talent_v2.model.entites.SkillTalentCrossRef
import com.ak.sodikov.talent_v2.model.entites.Talent


data class TalentWithSkill  (
    @Embedded val talent : Talent,
    @Relation (
        parentColumn = "talentId",
        entityColumn = "skillId",
        associateBy = Junction(
            value = SkillTalentCrossRef::class,
            parentColumn = "skillId",
            entityColumn = "talentId"
        )
            )
    val skills:  List <Skill>
        )
