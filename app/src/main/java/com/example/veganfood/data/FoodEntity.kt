package com.example.veganfood.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "name_table")
data class FoodEntity (
    @PrimaryKey(autoGenerate=true)
    val ImageId: Int? = null,
    val ImageBtnId: Int,
    val title: String,
    val suptitle: String,
    val inCart: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FoodEntity

        if (ImageId != other.ImageId) return false
        if (ImageBtnId != other.ImageBtnId) return false
        if (title != other.title) return false
        if (suptitle != other.suptitle) return false

        return true
    }

    override fun hashCode(): Int {
        var result = ImageId ?: 0
        result = 31 * result + ImageBtnId
        result = 31 * result + title.hashCode()
        result = 31 * result + suptitle.hashCode()
        return result
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<FoodEntity> {
        override fun createFromParcel(parcel: Parcel): FoodEntity {
            return FoodEntity(parcel)
        }

        override fun newArray(size: Int): Array<FoodEntity?> {
            return arrayOfNulls(size)
        }
    }
}