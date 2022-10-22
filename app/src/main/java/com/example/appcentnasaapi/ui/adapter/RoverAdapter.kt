package com.example.appcentnasaapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcentnasaapi.core.base.BaseListAdapter
import com.example.appcentnasaapi.databinding.RoverItemBinding
import com.example.appcentnasaapi.domain.model.roverResponse.Photo


import com.example.appcentnasaapi.core.extensions.OnItemClickListener
import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse
import com.example.appcentnasaapi.ui.viewholder.RoverViewHolder

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
class RoverAdapter(
    private val onItemClick : (roverPhoto : Photo) -> Unit
) : BaseListAdapter<Photo>(
    itemsSame = {old, new -> old == new},
    contentsSame = {old, new -> old.equals(new)}
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = RoverItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RoverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RoverViewHolder).apply {
            bind(getItem(position))
            onItemClickListener(onItemClick)
        }
    }

    override fun submitList(list: MutableList<Photo>?) {

        super.submitList(list)
    }

}