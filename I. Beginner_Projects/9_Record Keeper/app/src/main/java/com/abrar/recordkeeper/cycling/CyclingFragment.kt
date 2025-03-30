package com.abrar.recordkeeper.cycling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abrar.recordkeeper.constants.RecordConstants
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

    private fun setUpClickListeners() {
        binding.containerLongestRide.setOnClickListener { launchCyclingRecordScreen(RecordConstants.RECORD_LONGEST_RIDE, "Distance") }
        binding.containerBiggestClimb.setOnClickListener { launchCyclingRecordScreen(RecordConstants.RECORD_BIGGEST_CLIMB, "Height") }
        binding.containerBestAverageSpeed.setOnClickListener { launchCyclingRecordScreen(RecordConstants.RECORD_BEST_AVERAGE_SPEED, "Average Speed") }
    }

    private fun launchCyclingRecordScreen(record: String, recordFieldHint: String) {
        val intent = Intent(context, EditRecordActivity::class.java)
        intent.putExtra(EditRecordActivity.INTENT_EXTRA_SCREEN_DATA, EditRecordActivity.ScreenData(record, FILENAME, recordFieldHint))
        startActivity(intent)
    }

    private fun displayRecords() {
        val cyclingPreferences = requireContext().getSharedPreferences(FILENAME, AppCompatActivity.MODE_PRIVATE)

        binding.textViewLongestRideValue.text = cyclingPreferences.getString("${RecordConstants.RECORD_LONGEST_RIDE} ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textViewLongestRideDate.text = cyclingPreferences.getString("${RecordConstants.RECORD_LONGEST_RIDE} ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)
        binding.textViewBiggestClimbValue.text = cyclingPreferences.getString("${RecordConstants.RECORD_BIGGEST_CLIMB} ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textViewBiggestClimbDate.text = cyclingPreferences.getString("${RecordConstants.RECORD_BIGGEST_CLIMB} ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)
        binding.textViewBestAverageSpeedValue.text = cyclingPreferences.getString("${RecordConstants.RECORD_BEST_AVERAGE_SPEED} ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textViewBestAverageSpeedDate.text = cyclingPreferences.getString("${RecordConstants.RECORD_BEST_AVERAGE_SPEED} ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)
    }

    companion object {
        const val FILENAME = "cycling"
    }
}