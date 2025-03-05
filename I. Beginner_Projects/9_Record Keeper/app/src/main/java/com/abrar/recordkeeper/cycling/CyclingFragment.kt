package com.abrar.recordkeeper.cycling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abrar.recordkeeper.databinding.FragmentCyclingBinding
import com.abrar.recordkeeper.editrecord.EditRecordActivity

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

    private fun displayRecords() {
        val cyclingPreferences = requireContext().getSharedPreferences("cycling", AppCompatActivity.MODE_PRIVATE)



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

    private fun launchCyclingRecordScreen(record: String, recordFieldHint: String) {
        val intent = Intent(context, EditRecordActivity::class.java)
        intent.putExtra(
            "screen_data",
            EditRecordActivity.ScreenData(record, "cycling", recordFieldHint)
        )
        startActivity(intent)
    }
}