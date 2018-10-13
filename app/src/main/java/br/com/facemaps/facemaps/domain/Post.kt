package br.com.facemaps.facemaps.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
data class Post(var titulo: String, var descricao: String, var latitude: Double, var longitude: Double, var imagem: String): Parcelable {

    var id: Long? = null
    @SerializedName("data_post")
    var data: Date? = null
    @SerializedName("quant_votos")
    var quantVotos = 0
    var usuario: Usuario? = null

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readString()) {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        quantVotos = parcel.readInt()
        usuario = parcel.readParcelable(Usuario::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeString(descricao)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
        parcel.writeString(imagem)
        parcel.writeValue(id)
        parcel.writeInt(quantVotos)
        parcel.writeParcelable(usuario, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Post> {
        override fun createFromParcel(parcel: Parcel): Post {
            return Post(parcel)
        }

        override fun newArray(size: Int): Array<Post?> {
            return arrayOfNulls(size)
        }
    }

}