package com.luis.rickmorthy.view.adapter.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.luis.rickmorthy.R
import com.luis.rickmorthy.model.character
import com.luis.rickmorthy.view.adapter.viewholders.CharacterViewHolder

class CharacterAdapter (val characterListener : CharacterListener, viewType : Int) : RecyclerView.Adapter<CharacterViewHolder>(){

    val listCharacter = ArrayList<character>()

    override fun getItemCount(): Int {
        return listCharacter.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character : character = listCharacter[position]

        //IMAGE BIND
        Glide.with(holder.itemView.context)
            .load(character.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.imageCharacter)

        // CHARACTER NAME
        holder.characterName.text = character.name

        // CHARACTER STATUS
        holder.characterStatus.text = character.status

        // EVENT LISTENER
        holder.itemView.setOnClickListener{

        }
    }

    // IT ALLOWS TO INFLATE THE ITEM IN EACH ITERATION
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return  CharacterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_character,parent,false))
    }

}