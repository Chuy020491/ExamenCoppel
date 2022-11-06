package com.example.examencoppel.marvel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examencoppel.R
import com.example.examencoppel.marvel.model.SuperHeroModel

class MarvelFragmentAdapter (private val superHeroModelList: List<SuperHeroModel>, private val onClickListener: (SuperHeroModel)-> Unit): RecyclerView.Adapter<MarvelFragmentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelFragmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MarvelFragmentViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun onBindViewHolder(holder: MarvelFragmentViewHolder, position: Int) {
        val item =superHeroModelList[position]
        holder.render(item,onClickListener)
    }

    override fun getItemCount(): Int= superHeroModelList.size

}