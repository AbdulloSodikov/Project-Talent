package com.ak.sodikov.talent_v2.screens.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.ViewModelProvider
import com.ak.sodikov.talent_v2.R
import com.ak.sodikov.talent_v2.databinding.FragmentAddPersonBinding
import com.ak.sodikov.talent_v2.model.entites.Talent
import com.ak.sodikov.talent_v2.utillite.APP_ACTIVITY


class AddNewPersonFragment : Fragment() {
    private var binding: FragmentAddPersonBinding? = null
    private val mBinding get() = binding!!
    lateinit var mViewModel: AddNewPersonFragmentViewModel
    lateinit var autoCompleteWorkState : AutoCompleteTextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPersonBinding.inflate(inflater)

        return mBinding.root

    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewPersonFragmentViewModel::class.java)
        val workState = resources.getStringArray(R.array.work_state)
        val workStateAdapter = ArrayAdapter(requireContext(), R.layout.dropdpwn_item_work_state, workState)
        mBinding.autoCompletWorkState.setAdapter(workStateAdapter)

        mBinding.btnSave.setOnClickListener {
            val sureName = mBinding.textAddSureName.text.toString()
            val name = mBinding.textAddName.text.toString()

            if (name.isNullOrEmpty()) {
                mBinding.etAddSureName.error = "Необходимо запольнить"
            } else {
                mViewModel.insert(Talent(talentSurname = sureName, talentName = name)) {
                    APP_ACTIVITY.mNavController.navigate(R.id.action_addPersonFragment_to_listFragment)
                }
            }

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}