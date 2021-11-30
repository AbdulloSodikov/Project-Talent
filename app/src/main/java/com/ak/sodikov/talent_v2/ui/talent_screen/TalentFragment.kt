package com.ak.sodikov.talent_v2.ui.talent_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.ak.sodikov.talent_v2.databinding.FragmentTalentBinding
import com.ak.sodikov.talent_v2.model.entites.Talent
import com.ak.sodikov.talent_v2.utillite.REPOSITORY
import com.ak.sodikov.talent_v2.utillite.TALENT
import com.ak.sodikov.talent_v2.utillite.showToast
import kotlinx.coroutines.launch
import kotlin.properties.Delegates


class TalentFragment : Fragment() {
    private lateinit var binding: FragmentTalentBinding
    private val mBinding get() = binding!!
    private var idTalent by Delegates.notNull<Int>()
    private lateinit var mTalent: Talent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalentBinding.inflate(inflater)
        mTalent = arguments?.getSerializable(TALENT) as Talent
        return mBinding.root

    }
    override fun onStart() {
        super.onStart()
        initialization()
    }
    private fun initialization() {
        mBinding.tvFullNameTalent.text = " ${mTalent.talentSurname} ${mTalent.talentName}"
        mBinding.tvProfession.text = mTalent.professionNameInTalent
        mBinding.tvEducation.text = mTalent.education
        mBinding.tvAbout.text = mTalent.info
        mBinding.tvCity.text = mTalent.cityNameInTalent
    }
    suspend fun getData(id: Int) {
        lifecycleScope.launch {
            val talent = REPOSITORY.getTalent(0)
            showToast(talent.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}