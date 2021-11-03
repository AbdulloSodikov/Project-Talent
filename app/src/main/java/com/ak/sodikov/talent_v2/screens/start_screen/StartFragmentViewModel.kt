package com.ak.sodikov.talent_v2.screens.start_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ak.sodikov.talent_v2.db.AppTalentDatabase
import com.ak.sodikov.talent_v2.db.room.AppRoomRepositoryImpl
import com.ak.sodikov.talent_v2.utillite.REPOSITORY
import com.ak.sodikov.talent_v2.utillite.TYPE_ILMHONA
import com.ak.sodikov.talent_v2.utillite.TYPE_ROOM

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application

    fun initDataBase(typeDataBase: String, onSuccess: () -> Unit) {
        when (typeDataBase) {
            TYPE_ROOM -> {
                val dao = AppTalentDatabase.getInstance(mContext).getTalentDao()
                REPOSITORY = AppRoomRepositoryImpl(dao)
                onSuccess()
            }
            TYPE_ILMHONA -> {
            }
        }
    }
}

