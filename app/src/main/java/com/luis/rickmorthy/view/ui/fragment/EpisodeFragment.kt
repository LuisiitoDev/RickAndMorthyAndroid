package com.luis.rickmorthy.view.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.luis.rickmorthy.R
import com.luis.rickmorthy.model.episode
import com.luis.rickmorthy.view.adapter.episode.EpisodeAdapter
import com.luis.rickmorthy.view.adapter.episode.EpisodeListener
import com.luis.rickmorthy.viewmodel.EpisodeViewModel
import kotlinx.android.synthetic.main.fragment_episode.*


class EpisodeFragment : Fragment(), EpisodeListener {

    private lateinit var viewmodel : EpisodeViewModel
    private lateinit var episodeAdapter: EpisodeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_episode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = ViewModelProviders.of(this).get(EpisodeViewModel::class.java)
        viewmodel.refresh()
        episodeAdapter = EpisodeAdapter(this)

        rvEpisodes.apply {
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
            adapter = episodeAdapter
        }

        observerViewModel()
    }

    private fun observerViewModel(){
        viewmodel.listEpisodes.observe(this,Observer<List<episode>>{
            episodeAdapter.updateData(it)
        })

        viewmodel.isLoading.observe(this, Observer<Boolean>{
            if (it != null){
                rlBaseCharacters.visibility = View.INVISIBLE
            }
        })
    }

    override fun onEpisodeClicked(episode: episode, position: Int) {
        TODO("Not yet implemented")
    }

}