package com.ak.sodikov.talent_v2.db.room

import androidx.lifecycle.LiveData
import com.ak.sodikov.talent_v2.db.DatabaseRepository
import com.ak.sodikov.talent_v2.model.entites.Talent

class AppRoomRepositoryImpl(private val dao:AppTalentRoomDao) : DatabaseRepository {
    override val allTalent: LiveData<List<Talent>>
        get() = dao.getAllTalent()

    override suspend fun insertTalent(talent: Talent, onSuccess: () -> Unit) {
        dao.insertTalent(talent)
        onSuccess()
    }
}