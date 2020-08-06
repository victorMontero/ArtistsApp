package com.android.artistsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.android.artistsapp.R
import com.android.artistsapp.ui.ArtistViewModel
import com.android.artistsapp.ui.HomeActivity

class FavoriteArtistsFragment : Fragment(R.layout.fragment_favorite_artists) {

    lateinit var viewModel : ArtistViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as HomeActivity).viewModel
    }
}