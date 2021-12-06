package com.ak.sodikov.talent_v2.ui.talent_add_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.ViewModelProvider
import com.ak.sodikov.talent_v2.R
import com.ak.sodikov.talent_v2.databinding.FragmentTalentAddBinding
import com.ak.sodikov.talent_v2.model.entites.Talent
import com.ak.sodikov.talent_v2.utillite.APP_ACTIVITY
import com.ak.sodikov.talent_v2.utillite.showToast


class AddNewPersonFragment : Fragment() {
    private var binding: FragmentTalentAddBinding? = null
    private val mBinding get() = binding!!
    lateinit var mViewModel: AddNewPersonFragmentViewModel
    lateinit var autoCompleteWorkState: AutoCompleteTextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalentAddBinding.inflate(inflater)

        return mBinding.root

    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewPersonFragmentViewModel::class.java)
        val workStateArray = resources.getStringArray(R.array.work_state)
        val educationArray = resources.getStringArray(R.array.education)
        val professionArray = resources.getStringArray(R.array.profession)
        val cityArray = resources.getStringArray(R.array.city)


        val workStateAdapter =
            ArrayAdapter(requireContext(), R.layout.dropdpwn_item_work_state, workStateArray)
        mBinding.autoCompletWorkState.setAdapter(workStateAdapter)


        val educationAdapter =
            ArrayAdapter(requireContext(), R.layout.drop_down_item_education, educationArray)
        mBinding.autoCompletEducation.setAdapter(educationAdapter)


        val professionAdapter =
            ArrayAdapter(requireContext(), R.layout.drop_down_item_profession, professionArray)
        mBinding.autoCompletProfession.setAdapter(professionAdapter)


        val cityAdapter = ArrayAdapter(requireContext(), R.layout.drop_down_item_city, cityArray)
        mBinding.autoCompleteCity.setAdapter(cityAdapter)


        var workStateResult: String = ""
        var educationResult: String = ""
        var professionResult: String = ""
        var cityResult: String = ""

        mBinding.autoCompletWorkState.onItemClickListener =
            object : AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    workStateResult = workStateArray[p2].toString()
                }
            }


        mBinding.autoCompletEducation.onItemClickListener =
            object : AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    educationResult = educationArray[p2].toString()
                }
            }
        mBinding.autoCompletProfession.onItemClickListener =
            object : AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    professionResult = professionArray[p2].toString()
                }
            }


        mBinding.autoCompleteCity.onItemClickListener =
            object : AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    cityResult = cityArray[p2].toString()
                }
            }
        mBinding.btnSave.setOnClickListener {
            val sureNameResult = mBinding.textAddSureName.text.toString()
            val nameResult = mBinding.textAddName.text.toString()
            val emailResult = mBinding.textAddEmail.text.toString()
            val infoResult = mBinding.textAddAbout.text.toString()

            if (sureNameResult.isNullOrEmpty()) mBinding.etAddSureName.error =
                "Необходимо заполнить"
            if (nameResult.isNullOrEmpty()) mBinding.etAddName.error = "Необходимо заполнить"
            if (emailResult.isNullOrEmpty()) mBinding.etAddEmail.error = "Необходимо заполнить"
            if (workStateResult.isNullOrEmpty()) mBinding.autoCompletWorkState.error =
                "Необходимо заполнить"
            if (educationResult.isNullOrEmpty()) mBinding.autoCompletEducation.error =
                "Необходимо заполнить"
            if (professionResult.isNullOrEmpty()) mBinding.autoCompletProfession.error =
                "Необходимо заполнить"
            if (cityResult.isNullOrEmpty()) mBinding.autoCompleteCity.error = "Необходимо заполнить"
            else {
                val tamp = Talent(
                    talentSurname = sureNameResult,
                    talentName = nameResult,
                    email = emailResult,
                    workState = workStateResult,
                    info = infoResult,
                    education = educationResult,
                    professionNameInTalent = professionResult,
                    cityNameInTalent = cityResult,
                    urlAvatar = ""
                )
                mViewModel.insert(tamp) {
                    APP_ACTIVITY.mNavController.navigate(R.id.action_addPersonFragment_to_listFragment)
                    showToast("готово")
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}