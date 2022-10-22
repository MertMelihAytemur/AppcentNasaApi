package com.example.appcentnasaapi.ui.viewholder

import com.example.appcentnasaapi.core.base.BaseViewHolder
import com.example.appcentnasaapi.databinding.FragmentCuriosityBinding
import com.example.appcentnasaapi.databinding.RoverItemBinding
import com.example.appcentnasaapi.domain.model.roverResponse.Photo
import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
class RoverViewHolder(binding: RoverItemBinding) : BaseViewHolder<RoverItemBinding,Photo>(binding) {
    private lateinit var onItemClickListener : (roverPhoto : Photo) -> Unit
    override fun bind(item: Photo) {
        binding.photoDetail = item
    }

    fun onItemClickListener(listener : (roverPhoto : Photo) -> Unit){
        onItemClickListener = listener
    }

}