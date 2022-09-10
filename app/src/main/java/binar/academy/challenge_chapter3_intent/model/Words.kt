package binar.academy.challenge_chapter3_intent.model

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class Words(
    val alphabets: Char,
    val keywords: ArrayList<String>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt().toChar(),
        parcel.createStringArrayList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(alphabets.toInt())
        parcel.writeStringList(keywords)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Words> {
        override fun createFromParcel(parcel: Parcel): Words {
            return Words(parcel)
        }

        override fun newArray(size: Int): Array<Words?> {
            return arrayOfNulls(size)
        }
    }
}
