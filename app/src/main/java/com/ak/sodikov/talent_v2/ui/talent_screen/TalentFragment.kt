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
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import kotlin.properties.Delegates


class TalentFragment : Fragment() {
    private lateinit var binding: FragmentTalentBinding
    private val mBinding get() = binding!!
    private var idTalent by Delegates.notNull<Int>()
    private lateinit var mCurrentTalent: Talent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalentBinding.inflate(inflater)
        mCurrentTalent = arguments?.getSerializable(TALENT) as Talent
        return mBinding.root

    }
    override fun onStart() {
        super.onStart()
        initialization()
    }
    private fun initialization() {
        mBinding.apply {
            tvFullNameTalent.text = " ${mCurrentTalent.talentSurname} ${mCurrentTalent.talentName}"
            tvProfession.text = mCurrentTalent.professionNameInTalent
            tvEducation.text = mCurrentTalent.education
            tvAbout.text = mCurrentTalent.info
            tvCity.text = mCurrentTalent.cityNameInTalent
            Glide.with(talentAvatar.context)
                .load(mCurrentTalent.urlAvatar)
                .into(talentAvatar)
        }

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