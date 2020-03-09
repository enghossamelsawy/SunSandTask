package com.task.sunsporttask.mainScreen.data


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("name")
    val name: Name = Name(),
    @SerializedName("location")
    val location: Location = Location(),
    @SerializedName("email")
    val email: String = "",
    @SerializedName("login")
    val login: Login = Login(),
    @SerializedName("dob")
    val dob: Dob = Dob(),
    @SerializedName("registered")
    val registered: Registered = Registered(),
    @SerializedName("phone")
    val phone: String = "",
    @SerializedName("cell")
    val cell: String = "",
    @SerializedName("id")
    val id: Id = Id(),
    @SerializedName("picture")
    val picture: Picture = Picture(),
    @SerializedName("nat")
    val nat: String = ""
)