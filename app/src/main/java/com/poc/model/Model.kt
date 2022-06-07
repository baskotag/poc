package com.poc.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey val name: String,
    val imageUrl: String,
    val category: String,
    val desc: String
) : Parcelable