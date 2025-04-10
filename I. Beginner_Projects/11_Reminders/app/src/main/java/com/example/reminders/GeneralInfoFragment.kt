package com.example.reminders

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.reminders.databinding.DialogEditReminderBinding
import com.example.reminders.databinding.FragmentGeneralInfoBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GeneralInfoFragment: Fragment() {

    private lateinit var binding: FragmentGeneralInfoBinding
    private val preferences by lazy {
        requireActivity().getSharedPreferences("general_info", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGeneralInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayValues()
        binding.cardViewBin.setOnClickListener { showEditDialog(PREF_BIN) }
        binding.cardViewNationalInsurance.setOnClickListener { showEditDialog(PREF_NATIONAL_INSURANCE) }
        binding.cardViewWeedingAnniversary.setOnClickListener { showEditDialog(PREF_WEEDING_ANNIVERSARY) }
    }

    private fun displayValues() {
        binding.textViewBinValue.text = preferences.getString(PREF_BIN, null)
        binding.textViewNationalInsuranceValue.text = preferences.getString(PREF_NATIONAL_INSURANCE, null)
        binding.textViewWeedingAnniversaryValue.text = preferences.getString(PREF_WEEDING_ANNIVERSARY, null)
    }

    private fun showEditDialog(preferenceKey: String) {
        val dialogBinding = DialogEditReminderBinding.inflate(LayoutInflater.from(requireContext()))
        dialogBinding.editTextValue.setText(preferences.getString(preferenceKey, null))
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Update Value")
            .setView(dialogBinding.root)
            .setPositiveButton("save") { _, _ ->
                preferences.edit {putString(preferenceKey, dialogBinding.editTextValue.text?.toString())}
                displayValues()
            }
            .setNegativeButton("cancel") { dialog , _ ->
                dialog.dismiss()
            }.show()
    }

    companion object {
        const val PREF_BIN = "bin"
        const val PREF_NATIONAL_INSURANCE = "national_insurance"
        const val PREF_WEEDING_ANNIVERSARY = "weeding_anniversary"
    }
}