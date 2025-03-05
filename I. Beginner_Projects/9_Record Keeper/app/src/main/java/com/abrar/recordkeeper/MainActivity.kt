package com.abrar.recordkeeper

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.fragment.app.commit
import com.abrar.recordkeeper.cycling.CyclingFragment
import com.abrar.recordkeeper.databinding.ActivityMainBinding
import com.abrar.recordkeeper.running.RunningFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.reset_running -> {
            getSharedPreferences("running", Context.MODE_PRIVATE).edit() { clear() }
            true
        }
        R.id.reset_cycling -> {
            getSharedPreferences("cycling", Context.MODE_PRIVATE).edit() { clear() }
            true
        }
        R.id.reset_all -> {
            getSharedPreferences("running", Context.MODE_PRIVATE).edit() { clear() }
            getSharedPreferences("cycling", Context.MODE_PRIVATE).edit() { clear() }
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun onRunningClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
        return true
    }

    private fun onCyclingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.bottom_nav_run -> onRunningClicked()
        R.id.bottom_nav_bike -> onCyclingClicked()
        else -> false
    }
}