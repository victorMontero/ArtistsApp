package com.android.artistsapp.models


import com.google.gson.annotations.SerializedName

data class SearchResult(
    val band: String,
    val fmRadios: List<String>,
    val id: String,
    val url: String
)