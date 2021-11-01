package com.ak.sodikov.talent_v2.db.ilmhona

import androidx.lifecycle.LiveData
import com.ak.sodikov.talent_v2.db.DatabaseRepository
import com.ak.sodikov.talent_v2.model.entites.Talent

class AppIlmhonaRepository():DatabaseRepository {
    override val allTalent: LiveData<List<Talent>>
        get() = TODO("Not yet implemented")

    override suspend fun insertTalent(talent: Talent, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }
}