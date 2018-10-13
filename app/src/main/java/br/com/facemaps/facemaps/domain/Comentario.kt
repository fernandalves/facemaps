package br.com.facemaps.facemaps.domain

import android.os.Parcel
import android.os.Parcelable
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
data class Comentario(var conteudo: String): Parcelable {

    var id: Long? = null
    var data: Date? = null
    var usuario: Usuario? = null

    constructor(parcel: Parcel) : this(parcel.readString()) {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        usuario = parcel.readParcelable(Usuario::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(conteudo)
        parcel.writeValue(id)
        parcel.writeParcelable(usuario, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comentario> {
        override fun createFromParcel(parcel: Parcel): Comentario {
            return Comentario(parcel)
        }

        override fun newArray(size: Int): Array<Comentario?> {
            return arrayOfNulls(size)
        }
    }

}