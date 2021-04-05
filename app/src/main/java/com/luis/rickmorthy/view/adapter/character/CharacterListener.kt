package com.luis.rickmorthy.view.adapter.character

import com.luis.rickmorthy.model.character

interface CharacterListener {
    fun onCharacterClicked(character: character, position: Int)
}