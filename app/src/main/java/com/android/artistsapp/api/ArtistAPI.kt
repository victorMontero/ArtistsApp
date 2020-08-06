package com.android.artistsapp.api

import com.android.artistsapp.models.ArtistResponse
import com.android.artistsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistAPI {

    @GET("artist")
    suspend fun getArtists(
        @Query("genre")
        artistGenre: String = "rap",
        @Query("apikey")
        apiKey: String = API_KEY
    ): Response<ArtistResponse>

}