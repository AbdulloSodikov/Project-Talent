package com.ak.sodikov.talent_v2.ui

import android.app.Application
import com.ak.sodikov.talent_v2.model.entites.Talent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ak.sodikov.talent_v2.data.AppTalentDatabase
import com.ak.sodikov.talent_v2.data.api.RetrofitRepositoryImpl
import com.ak.sodikov.talent_v2.data.room.AppRoomRepositoryImpl
import com.ak.sodikov.talent_v2.model.entites.City
import com.ak.sodikov.talent_v2.model.entites.Profession
import com.ak.sodikov.talent_v2.model.entites.Skill
import com.ak.sodikov.talent_v2.utillite.REPOSITORY
import com.ak.sodikov.talent_v2.utillite.RETROFIT
import com.ak.sodikov.talent_v2.utillite.ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application

    fun initData( type : String) {
        val dao = AppTalentDatabase.getInstance(mContext).getTalentDao()

        when (type) {
            ROOM -> {
                REPOSITORY = AppRoomRepositoryImpl(dao)
            }
            RETROFIT -> {
                REPOSITORY = RetrofitRepositoryImpl(dao)
            }

        }

    }

    fun insertStateDataToDataBase(
        professionList: List<Profession>,
        cityList: List<City>,
        skillList: List<Skill>
    )
    {
        viewModelScope.launch(Dispatchers.Main) {
            professionList.forEach { REPOSITORY.insertProfession(it) }
            cityList.forEach { REPOSITORY.insertCity(it) }
            skillList.forEach { REPOSITORY.insertSkill(it) }
        }
    }
}

