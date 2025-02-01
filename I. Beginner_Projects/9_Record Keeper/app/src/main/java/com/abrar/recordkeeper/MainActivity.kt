package com.abrar.recordkeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.abrar.recordkeeper.databinding.ActivityMainBinding
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
            Toast.makeText(this, "Clicked on Reset Running Menu item", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.reset_cycling -> {
            Toast.makeText(this, "Clicked on Reset cycling Menu item", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.reset_all -> {
            Toast.makeText(this, "Clicked on Reset All Menu item", Toast.LENGTH_SHORT).show()
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