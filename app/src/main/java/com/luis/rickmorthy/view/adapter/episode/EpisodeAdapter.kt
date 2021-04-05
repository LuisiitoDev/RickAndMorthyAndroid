package com.luis.rickmorthy.view.adapter.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luis.rickmorthy.R
import com.luis.rickmorthy.model.episode
import com.luis.rickmorthy.view.adapter.viewholders.EpisodeViewHolder

class EpisodeAdapter (val episodeListener: EpisodeListener) : RecyclerView.Adapter<EpisodeViewHolder>(){

    val listEpisodes = ArrayList<episode>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return  EpisodeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_episode,parent,false))
    }

    override fun getItemCount(): Int {
        return  listEpisodes.size
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {

        val episode: episode = listEpisodes[position]

        holder.episodeName.text = "Name: ${episode.name}"
        holder.airDate.text = "Air Date: ${episode.air_date}"
        holder.episode.text = "Episode: ${episode.episode}"

        holder.itemView.setOnClickListener {

        }
    }

    fun updateData(data : List<episode>){
        listEpisodes.clear()
        listEpisodes.addAll(data)
        notifyDataSetChanged()
    }

}