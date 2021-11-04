package com.ak.sodikov.talent_v2.screens.talent_list_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ak.sodikov.talent_v2.R
import com.ak.sodikov.talent_v2.databinding.FragmentListBinding
import com.ak.sodikov.talent_v2.model.entites.Talent
import com.ak.sodikov.talent_v2.utillite.APP_ACTIVITY
import com.ak.sodikov.talent_v2.utillite.TALENT_ID
import com.ak.sodikov.talent_v2.utillite.showToast


class TalentListFragment : Fragment() {
    private var binding: FragmentListBinding? = null
    private val mBinding get() = binding!!
    private lateinit var mViewModelTalent: TalentListFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: TalentAdapter
    private lateinit var mObserverList: Observer<List<Talent>>

    private val someVar = "Hello world"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return mBinding.root
    }
    override fun onStart() {
        super.onStart()
        initialization()

    }
    private fun initialization() {
        mViewModelTalent = ViewModelProvider(this).get(TalentListFragmentViewModel::class.java)
        mAdapter = TalentAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter

        mAdapter.onItemClick = {
            val bundle = Bundle()
            bundle.putSerializable(TALENT_ID,it)
            APP_ACTIVITY.mNavController.navigate(R.id.action_listFragment_to_personFragment, bundle)
        }
        mObserverList = Observer {
            val list = it.asReversed()
            mAdapter.setList(list)
        }
        mViewModelTalent.allTalent.observe(viewLifecycleOwner,mObserverList)

                mBinding.btnAddTalent.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_listFragment_to_addPersonFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        mRecyclerView.adapter = null
        mViewModelTalent.allTalent.removeObserver(mObserverList)
    }
}