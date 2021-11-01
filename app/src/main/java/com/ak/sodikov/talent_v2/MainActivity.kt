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
     lateinit var db : AppTalentDatabase
     lateinit var roomDao: AppTalentRoomDao
     private var _binding : ActivityMainBinding? = null
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
        title = "Список Талантов"

         lifecycleScope.launchWhenCreated {
            dataSours ()
            getData("Dushanbe",3, 1) }



    }
    private  suspend fun dataSours() {
        val profession = listOf(
            Profession(0, "Android developer"),
            Profession(1, "Web developer"),
            Profession(2, "iOC developer"),
            Profession(3, "Full St")
        )

        val city = listOf(
            City(0, "Dushanbe"),
            City(1, "Khujand"),
            City(2, "Istaravshan"),
            City(3, "Масква")
        )
        val skills = listOf<Skill>(
            Skill(0, "Java"),
            Skill(1, "Kotlin"),
            Skill(2, "Swift"),
            Skill(3, "JavaScript")

        )

        var person = listOf(

            Talent(
                0, "Nurlaiev", "Muhammad", "nuraliev.m@gmail.com",
                "Работаю", "Я Нуралиев М.", "Android developer", "Dushanbe"
            ),
            Talent(
                1, "Sodikov", "Abdullo", "sodikov.a@gmail.com",
                "могу работать", "Я Содиков А.", "Web developer", "Khujand"
            ),
            Talent(
                2, "Ibodov", "Parviz", "parviz@gmail.com",
                "могу работать", "Y Parviz.", "iOC developer", "Moskov"
            ),
            Talent(
                3, "Sattorova", "Mati", "sattorova@gmail.com",
                " не могу работать", "Я.", "Full St", "Khujand"
            )
        )

        val skillsOfTalent = listOf(
            SkillTalentCrossRef(1, 0),
            SkillTalentCrossRef(3, 1),
            SkillTalentCrossRef(2, 1),
            SkillTalentCrossRef(3,4)

        )


        lifecycleScope.launch {
            profession.forEach { roomDao.insertProfession(it) }
            city.forEach { roomDao.insertCity(it) }
            skills.forEach { roomDao.insertSkills(it) }
            person.forEach { roomDao.insertTalent(it) }
            skillsOfTalent.forEach { roomDao.insertTalentAndSkills(it) }

        }

    }
    private suspend fun getData (nameCity: String, idProf : Int, idSkills: Int) {
          val allTalent = roomDao.getAllTalent().toString()
          val cityOfTalent = roomDao.getCityWithTalent(nameCity).toString()
          val professionOfTalent = roomDao.getProfessionWithTalents(idProf).toString()
          val skillsOfTalent = roomDao.getSkillsOfPerson(idSkills).toString()

            Log.d ("MyTag", allTalent)
            Log.d ("MyTag", cityOfTalent)
            Log.d ("MyTag", professionOfTalent)
            Log.d ("MyTag", skillsOfTalent)
      }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    }
