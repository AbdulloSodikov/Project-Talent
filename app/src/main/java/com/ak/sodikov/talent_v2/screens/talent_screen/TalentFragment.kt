package com.ak.sodikov.talent_v2.screens.talent_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.ak.sodikov.talent_v2.databinding.FragmentTalentBinding
import com.ak.sodikov.talent_v2.model.entites.Talent
import com.ak.sodikov.talent_v2.utillite.APP_ACTIVITY
import com.ak.sodikov.talent_v2.utillite.REPOSITORY
import com.ak.sodikov.talent_v2.utillite.TALENT_ID
import com.ak.sodikov.talent_v2.utillite.showToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.properties.Delegates


class TalentFragment : Fragment() {
    private lateinit var binding: FragmentTalentBinding
    private val mBinding get() = binding !!
    private var idTalent by Delegates.notNull<Int>()
    private lateinit var scope: CoroutineScope
    private lateinit var mTalent : Talent

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalentBinding.inflate(inflater)
        idTalent  = arguments?.getInt(TALENT_ID) as Int
        return mBinding.root


    }

    override fun onStart() {
        super.onStart()

        scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            val talent =  REPOSITORY.getTalent(idTalent).toString()
            showToast(talent)
        }


     /*   mBinding.tvFullNameTalent.text = " ${mTalent.talentSurname} ${mTalent.talentName}"
        mBinding.tvProfession.text = mTalent.professionNameInTalent
        mBinding.tvEducation.text = mTalent.education
        mBinding.tvAbout.text = mTalent.info
        mBinding.tvCity.text = mTalent.cityNameInTalent*/

     }


    suspend fun getData (id:Int) {
        lifecycleScope.launch {
          val talent =  REPOSITORY.getTalent(id)

        }

    }
       override fun onDestroy() {
        super.onDestroy()

    }
}