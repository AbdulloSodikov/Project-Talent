package com.ak.sodikov.talent_v2.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ak.sodikov.talent_v2.model.entites.City
import com.ak.sodikov.talent_v2.model.entites.Profession
import com.ak.sodikov.talent_v2.model.entites.Skill
import com.ak.sodikov.talent_v2.model.entites.SkillTalentCrossRef
import com.ak.sodikov.talent_v2.model.entites.relations.CityWithTalent
import com.ak.sodikov.talent_v2.model.entites.relations.TalentWithSkill
import com.ak.sodikov.talent_v2.model.entites.relations.ProfessionWithTalent
import com.ak.sodikov.talent_v2.model.entites.Talent

@Dao
interface AppTalentRoomDao {

    // Для добавления Таланта
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTalent(talent: Talent)

    // Для добавления списка Талантов
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTalents(talentList: List<Talent>)


    // для добовления Професии
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProfession(profession: Profession)

    // для добовления города
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCity(city: City)

    // для добовления навыков
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSkill(skill: Skill)

    // Для добавления Навыки и Таланты
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTalentAndSkills(skillTalentRef: SkillTalentCrossRef)


    // Получение всех добавленных Талантов
    @Query("SELECT * FROM talent ")
    fun getAllTalent(): LiveData<List<Talent>>

    // Получение Таланта по id
    @Query("SELECT * FROM talent WHERE talentId  = :id")
    fun getTalent(id: Int): LiveData<Talent>

    @Query ("DELETE  FROM talent")
    fun deleteAllTalent()



    //  Получение списка Талантов по професcии //
    @Transaction
    @Query("SELECT * FROM profession WHERE professionName = :professionName")
    suspend fun getProfessionWithTalents(professionName: Int): List<ProfessionWithTalent>

    /* Получение списка Талантов по городу */
    @Transaction
    @Query("SELECT * FROM city WHERE cityName = :nameCity")
    suspend fun getCityWithTalent(nameCity: String): List<CityWithTalent>

    //Получение списка Талантов по навкам

    @Transaction
    @Query("SELECT * FROM talent t, skillTalentCross st WHERE st.skillId = :skillId AND t.talentId = st.talentId")
    suspend fun getSkillsOfPerson(skillId: Int): List<TalentWithSkill>



}