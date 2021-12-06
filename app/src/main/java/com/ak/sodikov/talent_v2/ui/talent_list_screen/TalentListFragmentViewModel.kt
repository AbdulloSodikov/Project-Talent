package com.ak.sodikov.talent_v2.ui.talent_list_screen

import android.app.Application
import androidx.lifecycle.*
import com.ak.sodikov.talent_v2.data.AppTalentDatabase
import com.ak.sodikov.talent_v2.data.api.RetrofitRepositoryImpl

class TalentListFragmentViewModel (application: Application) : AndroidViewModel(application) {

    private var mContext = application

 /// Retrofit
  private val repositoryRetrofit = RetrofitRepositoryImpl()
   val allTalents = repositoryRetrofit.allTalents


/// ROOM
/*val dao = AppTalentDatabase.getInstance(mContext).getTalentDao()
    REPOSITORY = AppRoomRepositoryImpl(dao)
    val allTalent  = REPOSITORY.allTalent */

  }



