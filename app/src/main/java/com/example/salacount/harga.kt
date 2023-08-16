package com.example.salacount

import android.os.Parcel
import android.os.Parcelable

data class harga(var harga: String?):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<harga> {
        override fun createFromParcel(parcel: Parcel): harga {
            return harga(parcel)
        }

        override fun newArray(size: Int): Array<harga?> {
            return arrayOfNulls(size)
        }
    }
}