package com.poc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poc.R
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.poc.databinding.ActivityMainBinding
import com.poc.utility.hide
import com.poc.utility.show
import com.poc.viewModel.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.activityViewModel = ActivityViewModel()
        setContentView(binding.rootView)
        setSupportActionBar(binding.toolbar)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.containerFragment)
        setupActionBarWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    binding.appBarLayout.hide()
                }
                R.id.homeFragment -> {
                    setupToolbarTitleAndAction(getString(R.string.home), false)
                }
                R.id.detailsFragment -> {
                    setupToolbarTitleAndAction(getString(R.string.details), true)
                }
            }
        }
    }

    private fun setupToolbarTitleAndAction(title: String, isDisplayHomeAsUp: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(isDisplayHomeAsUp)
        binding.activityViewModel?.toolbarTitle?.set(title)
        binding.appBarLayout.show()
    }

}