package com.task.sunsporttask.mainScreen.data


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("street")
    val street: Street = Street(),
    @SerializedName("city")
    val city: String = "",
    @SerializedName("state")
    val state: String = "",
    @SerializedName("country")
    val country: String = "",
    @SerializedName("postcode")
    val postcode: Int = 0,
    @SerializedName("coordinates")
    val coordinates: Coordinates = Coordinates(),
    @SerializedName("timezone")
    val timezone: Timezone = Timezone()
)