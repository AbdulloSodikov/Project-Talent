package com.ak.sodikov.talent_v2.model.entites.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.ak.sodikov.talent_v2.model.entites.City
import com.ak.sodikov.talent_v2.model.entites.Talent

@Entity
data class CityWithTalent  (
    @Embedded val city : City,
    @Relation (
        parentColumn = "cityName",
        entityColumn = "talentName"
        )
    val talents: List <Talent>
)