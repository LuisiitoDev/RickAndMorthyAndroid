package com.luis.rickmorthy.view.adapter.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luis.rickmorthy.R

class EpisodeViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

    val episodeName = itemView.findViewById<TextView>(R.id.txtNameEpisode)
    val airDate = itemView.findViewById<TextView>(R.id.txtAirDate)
    val episode = itemView.findViewById<TextView>(R.id.txtepisode)
}