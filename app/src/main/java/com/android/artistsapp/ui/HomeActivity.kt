package com.android.artistsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.artistsapp.R
import com.android.artistsapp.db.ArtistDatabase
import com.android.artistsapp.repository.ArtistRepository
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var viewModel: ArtistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val artistRepository = ArtistRepository(ArtistDatabase(this))
        val viewModelProviderFactory = ArtistViewModelProviderFactory(artistRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(ArtistViewModel::class.java)
        bottom_navigation_view.setupWithNavController(nav_host_fragment.findNavController())
    }
}