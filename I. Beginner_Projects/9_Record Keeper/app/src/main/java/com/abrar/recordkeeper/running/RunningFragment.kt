package com.abrar.recordkeeper.running

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abrar.recordkeeper.constants.RecordConstants
import com.abrar.recordkeeper.databinding.FragmentRunningBinding
import com.abrar.recordkeeper.editrecord.EditRecordActivity

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRunningBinding.inflate(inflater, container, false)
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
        binding.container5km.setOnClickListener { launchRunningRecordScreen(RecordConstants.RECORD_5KM) }
        binding.container10km.setOnClickListener { launchRunningRecordScreen(RecordConstants.RECORD_10KM) }
        binding.containerHalfMarathon.setOnClickListener { launchRunningRecordScreen(RecordConstants.RECORD_HALF_MARATHON) }
        binding.containerMarathon.setOnClickListener { launchRunningRecordScreen(RecordConstants.RECORD_MARATHON) }
    }

    private fun displayRecords() {
        val runningPreferences = requireContext().getSharedPreferences(FILENAME, AppCompatActivity.MODE_PRIVATE)

        binding.textView5kmValue.text = runningPreferences.getString("${RecordConstants.RECORD_5KM} ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textView5kmDate.text = runningPreferences.getString("${RecordConstants.RECORD_5KM} ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)
        binding.textView10kmValue.text = runningPreferences.getString("${RecordConstants.RECORD_10KM} ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textView10kmDate.text = runningPreferences.getString("${RecordConstants.RECORD_10KM} ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)
        binding.textViewHalfMarathonValue.text = runningPreferences.getString("${RecordConstants.RECORD_HALF_MARATHON} ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textViewHalfMarathonDate.text = runningPreferences.getString("${RecordConstants.RECORD_HALF_MARATHON} ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)
        binding.textViewMarathonValue.text = runningPreferences.getString("${RecordConstants.RECORD_MARATHON} ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textViewMarathonDate.text = runningPreferences.getString("${RecordConstants.RECORD_MARATHON} ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)

    }

    private fun launchRunningRecordScreen(distance: String) {
        val intent = Intent(context, EditRecordActivity::class.java)

        intent.putExtra(EditRecordActivity.INTENT_EXTRA_SCREEN_DATA, EditRecordActivity.ScreenData(distance, FILENAME, "Time"))
        startActivity(intent)
    }

    companion object {

        const val FILENAME = "running"

    }

}