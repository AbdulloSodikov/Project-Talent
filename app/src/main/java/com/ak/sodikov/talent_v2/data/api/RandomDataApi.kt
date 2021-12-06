package com.ak.sodikov.talent_v2.data.api

import com.ak.sodikov.talent_v2.model.entites.Talent
import com.ak.sodikov.talent_v2.utillite.END_POINT
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RandomDataApi {

    @GET (END_POINT)
    fun getTalents() : Call<List<Talent>>
}