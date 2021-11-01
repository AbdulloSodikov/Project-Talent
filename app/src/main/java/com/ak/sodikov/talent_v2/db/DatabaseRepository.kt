package com.ak.sodikov.talent_v2.db

import androidx.lifecycle.LiveData
import com.ak.sodikov.talent_v2.model.entites.Talent

interface DatabaseRepository {
    val allTalent : LiveData<List<Talent>>
    suspend fun insertTalent (talent: Talent, onSuccess:()->Unit)
}