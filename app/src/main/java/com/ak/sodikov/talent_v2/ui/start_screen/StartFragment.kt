package com.ak.sodikov.talent_v2.ui.start_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ak.sodikov.talent_v2.R
import com.ak.sodikov.talent_v2.databinding.FragmentStartBinding
import com.ak.sodikov.talent_v2.utillite.APP_ACTIVITY



class StartFragment : Fragment() {
    private var binding: FragmentStartBinding? = null
    private val mBinding get() = binding!!
    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)

        mBinding.btnFindTalent.setOnClickListener {
              APP_ACTIVITY.mNavController.navigate(R.id.action_startFragment_to_listFragment)
            }
        mBinding.btnAddTalent.setOnClickListener {
             APP_ACTIVITY.mNavController.navigate(R.id.action_startFragment_to_addPersonFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}