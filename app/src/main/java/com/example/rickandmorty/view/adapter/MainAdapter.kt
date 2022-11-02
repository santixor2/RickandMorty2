package com.example.rickandmorty.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.databinding.MovieItemBinding
import com.example.rickandmorty.model.Characters

class MainAdapter(var listCharacter : List<Characters>): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(layoutInflater, parent , false)
        return MainViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bin(listCharacter[position])
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

   inner class MainViewHolder(private val binding : MovieItemBinding): RecyclerView.ViewHolder(binding.root){

       fun bin(characters: Characters){
           binding.apply {
               tvTitle.text = characters.name
               characters.image?.let { imgUrl ->
                   Glide.with(root.context)
                       .load(imgUrl)
                       .into(imHome)
               }

           }

       }

    }
}