package com.ak.sodikov.talent_v2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ak.sodikov.talent_v2.utillite.REPOSITORY


class MainActivityViewModel (application: Application) : AndroidViewModel(application) {
val allTalent = REPOSITORY.allTalent
}