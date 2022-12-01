package com.sildev.thecocktail.ui.setting

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.sildev.thecocktail.R
import com.sildev.thecocktail.base.BaseFragment
import com.sildev.thecocktail.databinding.FragmentSettingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SettingFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {

    override val viewModel: SettingViewModel by viewModel()
    private var isNightMode = false
    private var isEnglish = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.layoutNightMode.setOnClickListener {
            if (isNightMode) {
                changeNightMode(false)
            } else {
                changeNightMode(true)
            }
        }
        binding.layoutLanguage.setOnClickListener {
            changeLanguage()
        }

        viewModel.isNightMode.observe(viewLifecycleOwner) {
            binding.switchNightMode.isChecked = it
            isNightMode = it
        }

        viewModel.isEnglish.observe(viewLifecycleOwner) {
            if (it) {
                binding.textLanguage.text = getString(R.string.english)
            } else {
                binding.textLanguage.text = getString(R.string.vietnamese)
            }
            isEnglish = it
        }
    }

    private fun changeNightMode(isNightMode: Boolean) {
        AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
            .setMessage(getString(R.string.question_change_mode))
            .setPositiveButton(R.string.yes) { _, _ ->
                if (isNightMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                viewModel.setNightMode(isNightMode)
                activity?.recreate()
            }.setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun changeLanguage() {
        AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
            .setMessage(getString(R.string.question_change_language))
            .setPositiveButton(R.string.yes) { _, _ ->
                viewModel.setLanguage(isEnglish.not())
                activity?.recreate()
            }.setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }
            .show()
    }
}
