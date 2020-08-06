package com.android.artistsapp.api

import com.android.artistsapp.models.SearchResponse
import com.android.artistsapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {

    @GET("search.art?")
    suspend fun searchArtists(
        @Query("apikey")
        apiKey: String = Constants.API_KEY,
        @Query("q=")
        artistGenre: String
    ): Response<SearchResponse>
}