package com.android.artistsapp.repository

import com.android.artistsapp.api.RetrofitInstance
import com.android.artistsapp.db.ArtistDatabase

class ArtistRepository(
    val db: ArtistDatabase
) {

    suspend fun getArtist(artistGenre: String) =
        RetrofitInstance.api.getArtists(artistGenre)
}