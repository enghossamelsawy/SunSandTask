package com.task.sunsporttask.mainScreen.data


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Dob(
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("age")
    val age: Int = 0
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dob> {
        override fun createFromParcel(parcel: Parcel): Dob {
            return Dob(parcel)
        }

        override fun newArray(size: Int): Array<Dob?> {
            return arrayOfNulls(size)
        }
    }
}