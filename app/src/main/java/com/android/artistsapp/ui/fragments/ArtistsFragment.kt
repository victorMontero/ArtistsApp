package com.android.artistsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.artistsapp.R
import com.android.artistsapp.adapters.ArtistAdapter
import com.android.artistsapp.ui.ArtistViewModel
import com.android.artistsapp.ui.HomeActivity
import com.android.artistsapp.util.Resource
import kotlinx.android.synthetic.main.fragment_artists.*

class ArtistsFragment : Fragment(R.layout.fragment_artists) {

    lateinit var viewModel: ArtistViewModel
    lateinit var artistAdapter: ArtistAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as HomeActivity).viewModel
        setupRecyclerView()

        viewModel.artist.observe(viewLifecycleOwner, Observer {response ->
            when(response){
                is Resource.Success ->{
                    hideProgressBar()
                    response.data?.let { artistResponse ->
                        artistAdapter.differ.submitList(artistResponse.artist.genre.toList())
                        // response não entrega lista de artistas, aí não rola, preciso ver com os retornos do search,
                        // provavelmente rola pq é mais parecido com a resposta da news api
                        // vacilo não ter visto q artista não devolve musica, refatorar pra search
                        //https://youtu.be/TqGrjW3RY8o?t=676
                    }
            }
            is Resource.Error -> {
            hideProgressBar()
        }
            }
        })
    }

    private fun hideProgressBar() {
        progress_bar_artists_id.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progress_bar_artists_id.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(){
        artistAdapter = ArtistAdapter()
            recycler_view_artists_id.apply {
                adapter = artistAdapter
                layoutManager = LinearLayoutManager(activity)
            }
    }
}