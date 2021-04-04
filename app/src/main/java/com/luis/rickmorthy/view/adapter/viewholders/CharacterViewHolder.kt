package com.luis.rickmorthy.view.adapter.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luis.rickmorthy.R

class CharacterViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val imageCharacter = itemView.findViewById<ImageView>(R.id.ivImageCharacter)
    val characterName = itemView.findViewById<TextView>(R.id.txtcharacterName)
    val characterStatus = itemView.findViewById<TextView>(R.id.txtcharacterStatus)
}