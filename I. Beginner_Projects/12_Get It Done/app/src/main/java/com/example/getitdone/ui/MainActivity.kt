package com.example.getitdone.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.getitdone.R
import com.example.getitdone.data.model.TaskList
import com.example.getitdone.databinding.ActivityMainBinding
import com.example.getitdone.databinding.DialogAddTaskBinding
import com.example.getitdone.databinding.DialogAddTaskListBinding
import com.example.getitdone.databinding.TabButtonBinding
import com.example.getitdone.ui.tasks.StarredTasksFragment
import com.example.getitdone.ui.tasks.TasksFragment
import com.example.getitdone.util.InputValidator
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var currentTaskList: List<TaskList> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater).apply {

            lifecycleScope.launch {
                viewModel.getTaskLists().collectLatest { tasksLists ->
                    currentTaskList = tasksLists

                    pager.adapter = PagerAdapter(this@MainActivity, tasksLists)

                    pager.currentItem = 1
                    TabLayoutMediator(tabs, pager) { tab, position ->
                        when (position) {
                            0 -> tab.icon = ContextCompat.getDrawable(
                                this@MainActivity,
                                R.drawable.icon_star_filled
                            )

                            tasksLists.size + 1 -> {

                                val buttonBinding = TabButtonBinding.inflate(layoutInflater)

                                tab.customView = buttonBinding.root.apply{
                                    setOnClickListener { showAddTaskListDialog() }
                                }
                            }

                            else -> tab.text = tasksLists[position - 1].name
                        }
                    }.attach()
                }
            }

            fab.setOnClickListener { showAddTaskDialogue() }
            setContentView(root)

            ViewCompat.setOnApplyWindowInsetsListener(root) { view, insets ->
                val systemBarsInsets = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() or
                            WindowInsetsCompat.Type.displayCutout()
                )

                // Apply top padding only to the AppBarLayout to avoid status bar overlay
                root.setPadding(
                    systemBarsInsets.left,
                    systemBarsInsets.top,
                    systemBarsInsets.right,
                    systemBarsInsets.bottom
                )

                insets
            }
        }
    }

    private fun showAddTaskListDialog() {
        val dialogBinding = DialogAddTaskListBinding.inflate(layoutInflater)
        MaterialAlertDialogBuilder(this)
            .setTitle(getString(R.string.add_new_list_dialog_title))
            .setView(dialogBinding.root)
            .setPositiveButton(getString(R.string.create_button_text)) { dialog, _ ->
                viewModel.addNewTaskList(dialogBinding.editTextListName.text?.toString())
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.cancel_button_text)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showAddTaskDialogue() {
        DialogAddTaskBinding.inflate(layoutInflater).apply {
            val dialog = BottomSheetDialog(this@MainActivity)
            dialog.setContentView(root)

            buttonSave.isEnabled = false

            editTextTaskTitle.addTextChangedListener { input ->

                buttonSave.isEnabled = InputValidator.isInputValid(input?.toString())
            }

            buttonShowDetails.setOnClickListener {
                editTextTaskDetails.visibility =
                    if (editTextTaskDetails.isVisible) View.GONE else View.VISIBLE
            }


            buttonSave.setOnClickListener {
                val selectedTaskListId = currentTaskList[binding.pager.currentItem - 1].id
                viewModel.createTask(
                    editTextTaskTitle.text.toString(),
                    editTextTaskDetails.text.toString(),
                    listId = selectedTaskListId
                )
                dialog.dismiss()
            }

            dialog.show()
        }
    }

    inner class PagerAdapter(activity: FragmentActivity, private val taskLists: List<TaskList>) :
        FragmentStateAdapter(activity) {

        override fun getItemCount() = taskLists.size + 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> StarredTasksFragment()
                taskLists.size + 1 -> Fragment()
                else -> TasksFragment(taskLists[position - 1].id)
            }
        }
    }
}