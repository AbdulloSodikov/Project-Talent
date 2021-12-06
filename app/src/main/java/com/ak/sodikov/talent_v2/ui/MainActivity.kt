package com.ak.sodikov.talent_v2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ak.sodikov.talent_v2.R
import com.ak.sodikov.talent_v2.databinding.ActivityMainBinding
import com.ak.sodikov.talent_v2.model.entites.City
import com.ak.sodikov.talent_v2.model.entites.Profession
import com.ak.sodikov.talent_v2.model.entites.Skill
import com.ak.sodikov.talent_v2.utillite.APP_ACTIVITY
import com.ak.sodikov.talent_v2.utillite.RETROFIT
import com.ak.sodikov.talent_v2.utillite.ROOM

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val  mBinding get() = _binding!!
    lateinit var mToolbar: Toolbar
    lateinit var mNavController: NavController
    lateinit var mViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        initialization()

    }

    private fun initialization() {
        mNavController = Navigation.findNavController(this, R.id.nav_host)
        mToolbar = mBinding.toolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.title_talent)

        mViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        mViewModel.initData(RETROFIT)
        insertStateDataToDataBase()

    }
        private fun insertStateDataToDataBase() {
            val profession = listOf(
                Profession(0, "Web developer"),
                Profession(1, "Back-end developer"),
                Profession(2, "Full Stack developer"),
                Profession(3, "Android developer"),
                Profession(4, "iOC developer"),
                Profession(4, "Graphic developer"),
                Profession(4, "UX/UI developer"),
            )
            val city = listOf(
                City(0, "Душанбе"),
                City(1, "Хучанд"),
                City(2, "Истаравшан"),
                City(3, "Куляб"),
                City(4, "Хорог"),
                City(4, "Вахдат")
            )
            val skill = listOf(
                Skill(0, "Java"),
                Skill(1, "Kotlin"),
                Skill(2, "Swift"),
                Skill(3, "JavaScript")

            )
         mViewModel.insertStateDataToDataBase(profession,city, skill)
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
