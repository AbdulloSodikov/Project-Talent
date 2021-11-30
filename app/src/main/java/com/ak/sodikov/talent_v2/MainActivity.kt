package com.ak.sodikov.talent_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ak.sodikov.talent_v2.databinding.ActivityMainBinding
import com.ak.sodikov.talent_v2.db.AppTalentDatabase
import com.ak.sodikov.talent_v2.db.room.AppTalentRoomDao
import com.ak.sodikov.talent_v2.model.entites.City
import com.ak.sodikov.talent_v2.model.entites.Profession
import com.ak.sodikov.talent_v2.model.entites.Skill
import com.ak.sodikov.talent_v2.model.entites.SkillTalentCrossRef
import com.ak.sodikov.talent_v2.model.entites.Talent
import com.ak.sodikov.talent_v2.utillite.APP_ACTIVITY
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var db: AppTalentDatabase
    lateinit var roomDao: AppTalentRoomDao
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!
    lateinit var mToolbar: Toolbar
    lateinit var mNavController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mToolbar = mBinding.toolbar
        mNavController = Navigation.findNavController(this, R.id.nav_host)
        APP_ACTIVITY = this
        db = AppTalentDatabase.getInstance(this)
        roomDao = db.getTalentDao()

        setSupportActionBar(mToolbar)
        title = getString(R.string.title_talent)

        lifecycleScope.launchWhenCreated {
            dataSours()

        }
    }
        private suspend fun dataSours() {
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
            val skills = listOf<Skill>(
                Skill(0, "Java"),
                Skill(1, "Kotlin"),
                Skill(2, "Swift"),
                Skill(3, "JavaScript")

            )

            lifecycleScope.launch {
                profession.forEach { roomDao.insertProfession(it) }
                city.forEach { roomDao.insertCity(it) }
                skills.forEach { roomDao.insertSkills(it) }

            }
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null


    }
}
