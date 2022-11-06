package com.example.examencoppel.marvel.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.examencoppel.databinding.ItemSuperheroBinding
import com.example.examencoppel.marvel.model.SuperHeroModel

class MarvelFragmentViewHolder (view: View): RecyclerView.ViewHolder(view) {
    var binding = ItemSuperheroBinding.bind(view)

    fun render(superHeroModel: SuperHeroModel, onClickListener: (SuperHeroModel)-> Unit){
        binding.txtHeroName.text = superHeroModel.name

        itemView.setOnClickListener{
            onClickListener(superHeroModel)
        }
    }
}