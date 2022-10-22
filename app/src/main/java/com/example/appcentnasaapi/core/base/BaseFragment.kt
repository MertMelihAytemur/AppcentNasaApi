package com.example.appcentnasaapi.core.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.appcentnasaapi.core.extensions.progressDialog
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
abstract class BaseFragment : Fragment() {

    protected abstract fun initView()

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun viewModel(): BaseViewModel

    open fun initListeners() {}

    open fun initCollectors() {}

    private lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListeners()
        initCollectors()
        dialog = requireContext().progressDialog()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel().isLoading.collectLatest {
                    if (it) {
                        dialog.show()
                    } else {
                        dialog.dismiss()
                    }
                }
            }
        }
    }
}