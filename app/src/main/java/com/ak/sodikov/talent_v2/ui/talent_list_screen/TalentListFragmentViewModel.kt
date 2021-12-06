package com.ak.sodikov.talent_v2.ui.talent_list_screen

import android.app.Application
import androidx.lifecycle.*
import com.ak.sodikov.talent_v2.data.api.RetrofitRepositoryImpl

class TalentListFragmentViewModel (application: Application) : AndroidViewModel(application) {

  private val repositoryRetrofit = RetrofitRepositoryImpl()
   val allTalents = repositoryRetrofit.allTalents

  //val allTalent  = REPOSITORY.allTalent

  }



