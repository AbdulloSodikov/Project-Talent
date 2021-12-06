package com.ak.sodikov.talent_v2.db

import androidx.lifecycle.LiveData
import com.ak.sodikov.talent_v2.model.entites.City
import com.ak.sodikov.talent_v2.model.entites.Profession
import com.ak.sodikov.talent_v2.model.entites.Skill
import com.ak.sodikov.talent_v2.model.entites.Talent

interface Repository {
    val allTalent : LiveData<List<Talent>>

    suspend fun getTalent (id : Int) : LiveData<Talent>

    suspend fun insertTalent (talent: Talent, onSuccess:()->Unit)

    suspend fun insertTalents (talent: List<Talent>, onSuccess:()->Unit)

    suspend fun insertProfession (profession: Profession)

    suspend fun insertCity (city: City)

    suspend fun insertSkill (skill: Skill)

}