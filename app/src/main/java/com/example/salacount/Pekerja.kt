package com.example.salacount

import android.os.Parcel
import android.os.Parcelable

data class Pekerja(var pekerja: String?):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pekerja)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pekerja> {
        override fun createFromParcel(parcel: Parcel): Pekerja {
            return Pekerja(parcel)
        }

        override fun newArray(size: Int): Array<Pekerja?> {
            return arrayOfNulls(size)
        }
    }
}