package com.poc.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poc.utility.DBQuery.DATA_BASE_NAME
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = DATA_BASE_NAME)
data class Movie(
    @PrimaryKey val name: String,
    val imageUrl: String,
    val category: String,
    val desc: String
) : Parcelable