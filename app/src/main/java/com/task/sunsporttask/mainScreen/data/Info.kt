package com.task.sunsporttask.mainScreen.data


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("seed")
    val seed: String = "",
    @SerializedName("results")
    val results: Int = 0,
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("version")
    val version: String = ""
)