package com.abrar.recordkeeper.cycling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abrar.recordkeeper.CYCLING
import com.abrar.recordkeeper.databinding.FragmentCyclingBinding
import com.abrar.recordkeeper.editrecord.EditRecordActivity
import com.abrar.recordkeeper.editrecord.INTENT_EXTRA_SCREEN_DATA

class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpClickListeners()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun setUpClickListeners() {
        binding.containerLongestRide.setOnClickListener {
            launchCyclingRecordScreen(
                "Longest Ride",
                "Distance"
            )
        }
        binding.containerBiggestClimb.setOnClickListener {
            launchCyclingRecordScreen(
                "Biggest Climb",
                "Height"
            )
        }
        binding.containerBestAverageSpeed.setOnClickListener {
            launchCyclingRecordScreen(
                "Best Average Speed",
                "Average Speed"
            )
        }
    }

    private fun displayRecords() {
        val cyclingPreferences = requireContext().getSharedPreferences(CYCLING, AppCompatActivity.MODE_PRIVATE)

        binding.textViewLongestRideValue.text = cyclingPreferences.getString("Longest Ride record", null)
        binding.textViewLongestRideDate.text = cyclingPreferences.getString("Longest Ride date", null)
        binding.textViewBiggestClimbValue.text = cyclingPreferences.getString("Biggest Climb record", null)
        binding.textViewBiggestClimbDate.text = cyclingPreferences.getString("Biggest Climb date", null)
        binding.textViewBestAverageSpeedValue.text = cyclingPreferences.getString("Best Average Speed record", null)
        binding.textViewBestAverageSpeedDate.text = cyclingPreferences.getString("Best Average Speed date", null)
    }

    private fun launchCyclingRecordScreen(record: String, recordFieldHint: String) {
        val intent = Intent(context, EditRecordActivity::class.java)
        intent.putExtra(INTENT_EXTRA_SCREEN_DATA, EditRecordActivity.ScreenData(record, CYCLING, recordFieldHint))
        startActivity(intent)
    }
}