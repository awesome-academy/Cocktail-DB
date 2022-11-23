package com.sildev.thecocktail.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.sildev.thecocktail.utils.extension.showToast


abstract class BaseFragment<T : ViewBinding>(private val inflate: Inflate<T>) : Fragment() {

    protected val binding: T by lazy { inflate(layoutInflater) }
    abstract val viewModel: BaseViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.error.observe(viewLifecycleOwner) {
            view.context.showToast(it)
        }
    }
}
