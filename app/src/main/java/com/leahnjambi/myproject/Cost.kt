package com.leahnjambi.myproject

import android.os.Parcel
import android.os.Parcelable

data class Cost(val image:Int,val name:String ,val number: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(number)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cost> {
        override fun createFromParcel(parcel: Parcel): Cost {
            return Cost(parcel)
        }

        override fun newArray(size: Int): Array<Cost?> {
            return arrayOfNulls(size)
        }
    }
}
