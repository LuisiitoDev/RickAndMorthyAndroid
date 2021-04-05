package com.luis.rickmorthy.view.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luis.rickmorthy.R
import com.luis.rickmorthy.model.character
import com.luis.rickmorthy.view.adapter.character.CharacterAdapter
import com.luis.rickmorthy.view.adapter.character.CharacterListener
import com.luis.rickmorthy.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_character.*

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterFragment : Fragment(), CharacterListener {

    private lateinit var characterAdapter: CharacterAdapter
    private lateinit var characterViewModel : CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)
        characterViewModel.refresh()
        characterAdapter = CharacterAdapter(this)

        rvCharacters.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = characterAdapter
        }

        observerViewModel()
    }

    private fun observerViewModel(){
        characterViewModel.listCharacters.observe(this, Observer<List<character>>{
            it.let {
                characterAdapter.updateData(it)
            }
        })

        characterViewModel.isLoading.observe(this,Observer<Boolean>{
            if(it != null){
                rlBaseCharacters.visibility = View.INVISIBLE
            }
        })
    }


    override fun onCharacterClicked(character: character, position: Int) {
        TODO("Not yet implemented")
    }
}