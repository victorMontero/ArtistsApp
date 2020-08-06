package com.android.artistsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.artistsapp.R
import com.android.artistsapp.models.Artist
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistAdapter() : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {
    inner class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallBack = object  : DiffUtil.ItemCallback<Artist>(){
        override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        return ArtistViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_artist,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val artist = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(artist.url).into(item_image)
            item_name.text = artist.url
            setOnClickListener {
                onItemClickListener?.let { it(artist) }
            }
        }
    }

    private var onItemClickListener : ((Artist) -> Unit)? = null

    fun setOnItemClickListener(listener: (Artist) ->Unit){
        onItemClickListener = listener
    }


}