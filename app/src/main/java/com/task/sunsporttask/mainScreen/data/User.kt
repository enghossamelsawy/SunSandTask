package com.task.sunsporttask.mainScreen.data


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("name")
    val name: Name? = Name(),
    @SerializedName("location")
    val location: Location? = Location(),
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("login")
    val login: Login? = Login(),
    @SerializedName("dob")
    val dob: Dob? = Dob(),
    @SerializedName("registered")
    val registered: Registered? = Registered(),
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("cell")
    val cell: String? = "",
    @SerializedName("id")
    val id: Id? = Id(),
    @SerializedName("picture")
    val picture: Picture? = Picture(),
    @SerializedName("nat")
    val nat: String? = ""
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(Name::class.java.classLoader),
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.readString(),
        parcel.readParcelable(Login::class.java.classLoader),
        parcel.readParcelable(Dob::class.java.classLoader),
        parcel.readParcelable(Registered::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Id::class.java.classLoader),
        parcel.readParcelable(Picture::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gender)
        parcel.writeParcelable(name, flags)
        parcel.writeParcelable(location, flags)
        parcel.writeString(email)
        parcel.writeParcelable(login, flags)
        parcel.writeParcelable(dob, flags)
        parcel.writeParcelable(registered, flags)
        parcel.writeString(phone)
        parcel.writeString(cell)
        parcel.writeParcelable(id, flags)
        parcel.writeParcelable(picture, flags)
        parcel.writeString(nat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}