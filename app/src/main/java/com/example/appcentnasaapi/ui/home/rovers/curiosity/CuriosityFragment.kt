package com.example.appcentnasaapi.ui.home.rovers.curiosity

import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.viewModels
import com.example.appcentnasaapi.R
import com.example.appcentnasaapi.databinding.FragmentCuriosityBinding
import com.example.appcentnasaapi.ui.home.rovers.curiosity.state.CuriosityUiState
import com.example.appcentnasaapi.core.base.BaseFragment
import com.example.appcentnasaapi.core.base.BaseViewModel
import com.example.appcentnasaapi.core.extensions.collects
import com.example.appcentnasaapi.core.extensions.toast
import com.example.appcentnasaapi.domain.model.roverResponse.Photo
import com.example.appcentnasaapi.ui.adapter.RoverAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CuriosityFragment : BaseFragment() {
    private val viewModel: CuriosityViewModel by viewModels()
    private val binding: FragmentCuriosityBinding by viewBinding()

    private val mRoversAdapter = RoverAdapter(::onRoverClick)

    override fun initView() {
        binding.rvCuriosity.adapter = mRoversAdapter
    }

    override fun initCollectors() {
        viewModel.curiosityUiState.collects(viewLifecycleOwner) { result ->
            when (result) {
                is CuriosityUiState.Success -> {
                    mRoversAdapter.submitList(result.data.photos)
                    viewModel.clearUiState()
                }
                is CuriosityUiState.Error -> {
                    toast(result.error.localizedMessage)
                }
                is CuriosityUiState.Empty -> {}
            }
        }
    }


    private fun onRoverClick(roverPhoto : Photo){
        toast("clicked")
    }
    override fun layoutRes(): Int = R.layout.fragment_curiosity
    override fun viewModel(): BaseViewModel = viewModel
}