package com.android.artistsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.artistsapp.models.ArtistResponse
import com.android.artistsapp.repository.ArtistRepository
import com.android.artistsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ArtistViewModel(
    val artistRepository : ArtistRepository
) : ViewModel() {

    val artist: MutableLiveData<Resource<ArtistResponse>> = MutableLiveData()
    var artistPage = 1

    fun getArtist(artistGenre: String) = viewModelScope.launch {
        artist.postValue(Resource.Loading())
        val response = artistRepository.getArtist(artistGenre)
        artist.postValue(handleArtistResponse(response))

    }

    private fun handleArtistResponse(response: Response<ArtistResponse>) : Resource<ArtistResponse>{
        if(response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}