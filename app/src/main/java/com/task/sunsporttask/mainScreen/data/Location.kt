package com.task.sunsporttask.mainScreen.data


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("street")
    val street: Street? = Street(),
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("state")
    val state: String? = "",
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("postcode")
    val postcode: String? = "",
    @SerializedName("coordinates")
    val coordinates: Coordinates? = Coordinates(),
    @SerializedName("timezone")
    val timezone: Timezone? = Timezone()
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Street::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Coordinates::class.java.classLoader),
        parcel.readParcelable(Timezone::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(street, flags)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(country)
        parcel.writeString(postcode)
        parcel.writeParcelable(coordinates, flags)
        parcel.writeParcelable(timezone, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }
}