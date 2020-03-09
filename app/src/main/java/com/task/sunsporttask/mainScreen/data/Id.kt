package com.task.sunsporttask.mainScreen.data


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("value")
    val value: String? = ""
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Id> {
        override fun createFromParcel(parcel: Parcel): Id {
            return Id(parcel)
        }

        override fun newArray(size: Int): Array<Id?> {
            return arrayOfNulls(size)
        }
    }
}