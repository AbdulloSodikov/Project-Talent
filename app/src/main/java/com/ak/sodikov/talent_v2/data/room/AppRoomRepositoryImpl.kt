package com.ak.sodikov.talent_v2.data.room

import androidx.lifecycle.LiveData
import com.ak.sodikov.talent_v2.data.Repository
import com.ak.sodikov.talent_v2.model.entites.City
import com.ak.sodikov.talent_v2.model.entites.Profession
import com.ak.sodikov.talent_v2.model.entites.Skill
import com.ak.sodikov.talent_v2.model.entites.Talent

class AppRoomRepositoryImpl(private val dao:AppTalentRoomDao) : Repository {
    override val allTalents: LiveData<List<Talent>>
        get() = dao.getAllTalent()

    override suspend fun getTalent(id: Int):  LiveData<Talent> {
        return dao.getTalent(id)
    }

    override suspend fun insertTalent(talent: Talent) {
        dao.insertTalent(talent)

    }

    override suspend fun insertTalents(talents: List<Talent>) {
        dao.insertTalents(talents)

    }

    override suspend fun insertProfession(profession: Profession) {
        dao.insertProfession(profession)
    }
    override suspend fun insertCity(city: City) {
        dao.insertCity(city)
    }
    override suspend fun insertSkill(skill: Skill) {
        dao.insertSkill(skill)
    }

    override suspend fun deleteAllTalent() {
        dao.deleteAllTalent()
    }

}