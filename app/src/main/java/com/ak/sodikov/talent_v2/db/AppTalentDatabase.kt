package com.ak.sodikov.talent_v2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ak.sodikov.talent_v2.db.room.AppTalentRoomDao
import com.ak.sodikov.talent_v2.model.entites.*
import com.ak.sodikov.talent_v2.model.entites.Talent


@Database (
    entities = [
        Profession :: class,
        Talent :: class,
        City :: class,
        Skill :: class,
        SkillTalentCrossRef :: class
    ],
    version = 1
)
abstract class AppTalentDatabase : RoomDatabase (){
    abstract fun getTalentDao (): AppTalentRoomDao

    companion object {
        @Volatile
        private var INSTANCE : AppTalentDatabase? = null

        @Synchronized
        fun getInstance (context: Context) : AppTalentDatabase {
           return if (INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(
                   context,
                   AppTalentDatabase :: class.java,
                   "talent_db"
                 ).build()
               INSTANCE as AppTalentDatabase
            } else INSTANCE as AppTalentDatabase
        }
    }
}
