package com.task.sunsporttask.mainScreen.data


import com.google.gson.annotations.SerializedName

data class MainUserResponse(
    @SerializedName("results")
    val users: List<User> = listOf(),
    @SerializedName("info")
    val info: Info = Info()
)