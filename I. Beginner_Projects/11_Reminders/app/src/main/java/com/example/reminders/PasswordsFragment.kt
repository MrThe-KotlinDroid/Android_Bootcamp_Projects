package com.example.reminders

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.reminders.databinding.FragmentPasswordsBinding

class PasswordsFragment: Fragment() {

    private lateinit var binding: FragmentPasswordsBinding
    private val preferences by lazy {
       requireActivity().getSharedPreferences("passwords", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPasswordsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayValues()
    }

    private fun displayValues() {
        binding.textViewWifiValue.text = preferences.getString("pref_wifi", null)
        binding.textViewTabletPinValue.text = preferences.getString("pref_tablet_pin", null)
        binding.textViewBikeLockValue.text = preferences.getString("pref_bike_lock", null)
    }
}