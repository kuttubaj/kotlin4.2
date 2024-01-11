package com.example.kotlin42.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin42.databinding.ItemAnimeBinding
import com.example.kotlin42.presentation.data.models.Anime

class AnimeAdapter: RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var animeList = mutableListOf<Anime>()

    fun setAnimeList(animeList: MutableList<Anime>){
        this.animeList = animeList
    }
    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
       RecyclerView.ViewHolder(binding.root){

        fun onBind(anime: Anime) {
            binding.ivImage.setImageResource(anime.image)
            binding.tvText.text = anime.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
      return AnimeViewHolder(
          ItemAnimeBinding.inflate(LayoutInflater.from(parent.context))
      )
    }

    override fun onBindViewHolder(holder: AnimeAdapter.AnimeViewHolder, position: Int) {
        holder.onBind(animeList[position])
    }

    override fun getItemCount(): Int {
      return animeList.size
    }
}