package com.example.retrofitapi

import android.os.Parcel
import android.os.Parcelable

data class PostModel(
    val visibility:String,
    val id:Int,
    val name:String,
    val full_name:String,
    val html_url:String

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(visibility)
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(full_name)
        parcel.writeString(html_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostModel> {
        override fun createFromParcel(parcel: Parcel): PostModel {
            return PostModel(parcel)
        }

        override fun newArray(size: Int): Array<PostModel?> {
            return arrayOfNulls(size)
        }
    }
}
