package com.android.artistsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.artistsapp.models.Artist

@Dao
interface ArtistDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(artist: Artist): Long

    @Query("SELECT * FROM artists")
    fun getAllArtists(): LiveData<List<Artist>>

    @Delete
    suspend fun deleteArtist(artist: Artist)
}