package br.com.facemaps.facemaps.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
data class Usuario(var username: String, var password: String, var email: String): Parcelable {

    var id: Long? = null
    @SerializedName("first_name")
    var firstName = ""
    @SerializedName("last_name")
    var lastName = ""

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        firstName = parcel.readString()
        lastName = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(email)
        parcel.writeValue(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }

}