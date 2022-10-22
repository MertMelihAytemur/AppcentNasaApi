package com.example.appcentnasaapi.ui.home.rovers.spirit

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.viewbinding.library.fragment.viewBinding
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcentnasaapi.R
import com.example.appcentnasaapi.databinding.FragmentSpiritBinding
import com.example.appcentnasaapi.domain.model.roverResponse.Photo
import com.example.appcentnasaapi.ui.adapter.RoverAdapter
import com.example.appcentnasaapi.core.base.BaseFragment
import com.example.appcentnasaapi.core.base.BaseViewModel
import com.example.appcentnasaapi.core.extensions.OnItemClickListener
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SpiritFragment : BaseFragment() {
    private val binding : FragmentSpiritBinding by viewBinding()
    private val viewModel : SpiritViewModel by viewModels()

    override fun initView() {

    }

    override fun layoutRes(): Int = R.layout.fragment_spirit
    override fun viewModel(): BaseViewModel = viewModel
}