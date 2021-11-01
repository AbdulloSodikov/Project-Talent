package com.ak.sodikov.talent_v2.model.entites.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.ak.sodikov.talent_v2.model.entites.Profession
import com.ak.sodikov.talent_v2.model.entites.Talent


data class ProfessionWithTalent (
    @Embedded val profession : Profession,

    @Relation (
        parentColumn = "professionName",
        entityColumn = "professionName"
            )
    var talents : List <Talent>

        )
