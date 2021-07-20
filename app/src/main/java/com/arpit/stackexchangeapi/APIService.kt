package com.arpit.stackexchangeapi

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val base_url = "https://api.stackexchange.com/"


interface APIService {
    @GET("/2.3/questions/featured?order=desc&sort=activity&site=stackoverflow")
    suspend fun getQuestions(@Query("page") page :Int,
                          @Query("pagesize") pagesize :Int,
                          @Query("todate") todate :Int) : Response<ResponseStack>
}

object  questionsService {
    val apiService : APIService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(APIService::class.java)
    }
}



