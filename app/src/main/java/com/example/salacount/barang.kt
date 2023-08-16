package com.example.salacount

import android.os.Parcel
import android.os.Parcelable


data class Barang(var nama: String?): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Barang> {
        override fun createFromParcel(parcel: Parcel): Barang {
            return Barang(parcel)
        }

        override fun newArray(size: Int): Array<Barang?> {
            return arrayOfNulls(size)
        }
    }

}