package com.ak.sodikov.talent_v2.data.api


import com.ak.sodikov.talent_v2.utillite.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient  {
    //1 Работа с Retrofit

    var retrofitInstance : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRandomDataApi(): RandomDataApi = retrofitInstance.create(RandomDataApi::class.java)


}