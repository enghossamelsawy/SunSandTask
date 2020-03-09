package com.task.sunsporttask.mainScreen.data


import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("value")
    val value: String = ""
)