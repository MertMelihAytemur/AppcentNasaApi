package com.example.appcentnasaapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcentnasaapi.databinding.RoverItemBinding
import com.example.appcentnasaapi.model.roverResponse.Photo


import com.example.appcentnasaapi.util.extensions.OnItemClickListener

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
class RoverAdapter(
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RoverAdapter.RoverViewHolder>() {

    private var photos = mutableListOf<Photo>()

    class RoverViewHolder(private val itemBinding: RoverItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(listener : OnItemClickListener, photoDetail : Photo) {
            itemBinding.onItemClickListener = listener
            itemBinding.photoDetail = photoDetail
            itemBinding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): RoverViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RoverItemBinding.inflate(layoutInflater, parent, false)

                return RoverViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RoverViewHolder.from(parent)

    override fun onBindViewHolder(holder: RoverViewHolder, position: Int) {
        holder.bind(onItemClickListener,photos[position])
    }

    override fun getItemCount() = photos.size

    fun updateList(_photos: MutableList<Photo>) {
        photos = _photos
        notifyDataSetChanged()
    }

}