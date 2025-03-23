package com.abrar.recordkeeper.running

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abrar.recordkeeper.databinding.FragmentRunningBinding
import com.abrar.recordkeeper.editrecord.EditRecordActivity
import com.abrar.recordkeeper.editrecord.INTENT_EXTRA_SCREEN_DATA

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
        binding.container5km.setOnClickListener { launchRunningRecordScreen("5km") }
        binding.container10km.setOnClickListener { launchRunningRecordScreen("10km") }
        binding.containerHalfMarathon.setOnClickListener { launchRunningRecordScreen("Half Marathon") }
        binding.containerMarathon.setOnClickListener { launchRunningRecordScreen("Marathon") }
    }

    private fun displayRecords() {
        val runningPreferences = requireContext().getSharedPreferences(FILENAME, AppCompatActivity.MODE_PRIVATE)

        binding.textView5kmValue.text = runningPreferences.getString("5km ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textView5kmDate.text = runningPreferences.getString("5km ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)
        binding.textView10kmValue.text = runningPreferences.getString("10km ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textView10kmDate.text = runningPreferences.getString("10km ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)
        binding.textViewHalfMarathonValue.text = runningPreferences.getString("Half Marathon ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textViewHalfMarathonDate.text = runningPreferences.getString("Half Marathon ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)
        binding.textViewMarathonValue.text = runningPreferences.getString("Marathon ${EditRecordActivity.SHARED_PREFERENCES_RECORD_KEY}", null)
        binding.textViewMarathonDate.text = runningPreferences.getString("Marathon ${EditRecordActivity.SHARED_PREFERENCES_DATE_KEY}", null)

    }

    private fun launchRunningRecordScreen(distance: String) {
        val intent = Intent(context, EditRecordActivity::class.java)

        intent.putExtra(INTENT_EXTRA_SCREEN_DATA, EditRecordActivity.ScreenData(distance, FILENAME, "Time"))
        startActivity(intent)
    }

    companion object {

        const val FILENAME = "running"

    }

}