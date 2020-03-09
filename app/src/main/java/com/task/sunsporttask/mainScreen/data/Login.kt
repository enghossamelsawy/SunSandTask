package com.task.sunsporttask.mainScreen.data


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("uuid")
    val uuid: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("password")
    val password: String? = "",
    @SerializedName("salt")
    val salt: String? = "",
    @SerializedName("md5")
    val md5: String? = "",
    @SerializedName("sha1")
    val sha1: String? = "",
    @SerializedName("sha256")
    val sha256: String? = ""
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uuid)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(salt)
        parcel.writeString(md5)
        parcel.writeString(sha1)
        parcel.writeString(sha256)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Login> {
        override fun createFromParcel(parcel: Parcel): Login {
            return Login(parcel)
        }

        override fun newArray(size: Int): Array<Login?> {
            return arrayOfNulls(size)
        }
    }
}