package com.ak.sodikov.talent_v2.ui.talent_add_screen

import android.app.Application
import com.ak.sodikov.talent_v2.model.entites.Talent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ak.sodikov.talent_v2.utillite.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewPersonFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun insert(talent: Talent, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insertTalent(talent) {
                onSuccess()
            }
        }
    }
}
