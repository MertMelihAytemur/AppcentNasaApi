package com.example.appcentnasaapi.core.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
abstract class BaseViewHolder<T : ViewDataBinding, Item>(
    val binding: T
) : RecyclerView.ViewHolder(binding.root){
    abstract fun bind(item: Item)
}