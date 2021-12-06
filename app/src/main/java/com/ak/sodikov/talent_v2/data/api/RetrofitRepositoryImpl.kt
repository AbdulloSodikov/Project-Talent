package com.ak.sodikov.talent_v2.data.api

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ak.sodikov.talent_v2.R
import com.ak.sodikov.talent_v2.data.Repository
import com.ak.sodikov.talent_v2.data.room.AppTalentRoomDao
import com.ak.sodikov.talent_v2.model.entites.City
import com.ak.sodikov.talent_v2.model.entites.Profession
import com.ak.sodikov.talent_v2.model.entites.Skill
import com.ak.sodikov.talent_v2.model.entites.Talent
import com.ak.sodikov.talent_v2.utillite.APP_ACTIVITY
import com.ak.sodikov.talent_v2.utillite.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepositoryImpl (/*private val dao: AppTalentRoomDao*/) : Repository  {

    override val allTalents: LiveData<List<Talent>>
        get() = talents

    private var talents = MutableLiveData<List<Talent>>()

    val api = RetrofitClient.getRandomDataApi()
        .getTalents()
        .enqueue(object : Callback<List<Talent>> {
            override fun onResponse(
                call: Call<List<Talent>>,
                response: Response<List<Talent>>
            ) {
                Log.d("TEST_TAG", "onResponse : $response")
                if (!response.isSuccessful) return
                Log.d("TEST_TAG", "after return : $response")
                if (response.body() != null) {
                    talents.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Talent>>, t: Throwable) {
                Log.d("TEST_TAG", "onFailure: Нет подключения")
                showToast("Нет подключения")
                //talents = dao.getAllTalent() as MutableLiveData<List<Talent>>
            }
        })

    override suspend fun getTalent(id: Int): LiveData<Talent> {
        TODO("Not yet implemented")
    }

    override suspend fun insertTalent(talent: Talent) {
        TODO("Not yet implemented")
    }


    override suspend fun insertTalents(talent: List<Talent>) {

    }

    override suspend fun insertProfession(profession: Profession) {
        TODO("Not yet implemented")
    }

    override suspend fun insertCity(city: City) {
        TODO("Not yet implemented")
    }

    override suspend fun insertSkill(skill: Skill) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllTalent() {
        TODO("Not yet implemented")
    }
}