package com.ak.sodikov.talent_v2.utillite

import com.ak.sodikov.talent_v2.ui.MainActivity
import com.ak.sodikov.talent_v2.db.Repository
import com.ak.sodikov.talent_v2.db.room.AppTalentRoomDao

lateinit var APP_ACTIVITY : MainActivity
lateinit var REPOSITORY : Repository

const val TALENT = "talent_id"
const val BASE_URL = "https://random-data-api.com/api/"
const val END_POINT = "users/random_user?size=5"