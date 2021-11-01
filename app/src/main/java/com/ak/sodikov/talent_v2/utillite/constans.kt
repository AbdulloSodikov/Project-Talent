package com.ak.sodikov.talent_v2.utillite

import com.ak.sodikov.talent_v2.MainActivity
import com.ak.sodikov.talent_v2.db.DatabaseRepository
import com.ak.sodikov.talent_v2.db.room.AppTalentRoomDao

lateinit var APP_ACTIVITY : MainActivity
lateinit var RoomDAOApp : AppTalentRoomDao
lateinit var REPOSITORY : DatabaseRepository


const val TYPE_DATABASE = "typ_database"
const val TYPE_ROOM = "type_room"
const val TYPE_ILMHONA = "type_ilmhona"