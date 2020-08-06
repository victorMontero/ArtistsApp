package com.android.artistsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.artistsapp.repository.ArtistRepository

class ArtistViewModelProviderFactory(
    val artistRepository: ArtistRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(artistRepository) as T
    }
}