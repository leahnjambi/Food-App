package com.leahnjambi.myproject

import android.os.Parcel
import android.os.Parcelable

data class Calculate(val image:Int, val name:String,val cost:String,):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(cost)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Calculate> {
        override fun createFromParcel(parcel: Parcel): Calculate {
            return Calculate(parcel)
        }

        override fun newArray(size: Int): Array<Calculate?> {
            return arrayOfNulls(size)
        }
    }
}
