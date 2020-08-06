package com.android.artistsapp.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "artists"
)
data class Artist(
    val desc: String,
    val genre: List<Any>,
    @PrimaryKey(autoGenerate = true)
    var newId: Int? = null,
    val id: String,
    @SerializedName("pic_medium")
    val picMedium: String,
    @SerializedName("pic_small")
    val picSmall: String,
    val related: List<Any>,
    val url: String
)