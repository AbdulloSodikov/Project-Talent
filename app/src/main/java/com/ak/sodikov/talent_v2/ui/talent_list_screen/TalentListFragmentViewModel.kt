package com.ak.sodikov.talent_v2.ui.talent_list_screen

import android.app.Application
import androidx.lifecycle.*

import com.ak.sodikov.talent_v2.utillite.REPOSITORY

class TalentListFragmentViewModel (application: Application) : AndroidViewModel(application) {

  val allTalent  = REPOSITORY.allTalent

  }



