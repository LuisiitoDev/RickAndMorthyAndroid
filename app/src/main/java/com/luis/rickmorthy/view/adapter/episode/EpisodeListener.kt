package com.luis.rickmorthy.view.adapter.episode

import com.luis.rickmorthy.model.episode

interface EpisodeListener {
    fun onEpisodeClicked(episode: episode, position: Int)
}