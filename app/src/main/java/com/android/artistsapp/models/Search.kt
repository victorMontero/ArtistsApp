package com.android.artistsapp.models


data class Search(
    val searchResults: List<SearchResult>,
    val numFound: Int,
    val numFoundExact: Boolean,
    val start: Int
)