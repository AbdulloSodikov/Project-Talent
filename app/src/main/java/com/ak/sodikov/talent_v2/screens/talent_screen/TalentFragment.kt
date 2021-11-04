package com.ak.sodikov.talent_v2.screens.talent_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ak.sodikov.talent_v2.R
import com.ak.sodikov.talent_v2.databinding.FragmentTalentBinding


class TalentFragment : Fragment() {
    private lateinit var binding: FragmentTalentBinding
    private val mBinding get() = binding !!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalentBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}