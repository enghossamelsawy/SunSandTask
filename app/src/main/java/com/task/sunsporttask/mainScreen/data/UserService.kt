package com.task.sunsporttask.mainScreen.data

import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET(".")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("results") numberOfItemPerPage: Int): MainUserResponse
}