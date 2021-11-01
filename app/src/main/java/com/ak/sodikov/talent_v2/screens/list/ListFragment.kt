package com.ak.sodikov.talent_v2.screens.list

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


class ListFragment : Fragment() {
    private var binding: FragmentListBinding? = null
    private val mBinding get() = binding!!
    private lateinit var mViewModel: ListFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: TalentAdapter
    private lateinit var mObserverList: Observer<List<Talent>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(ListFragmentViewModel::class.java)
        mAdapter = TalentAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it.asReversed()
            mAdapter.setList(list)
        }
        mViewModel.allTalent.observe(this,mObserverList)
        mBinding.btnAddTalent.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_listFragment_to_addPersonFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        mRecyclerView.adapter = null
        mViewModel.allTalent.removeObserver(mObserverList)
    }
}