package com.example.appcentnasaapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.viewpager2.widget.ViewPager2
import com.example.appcentnasaapi.R
import com.example.appcentnasaapi.databinding.ActivityMainBinding
import com.example.appcentnasaapi.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            when(position){
                0 -> tab.text = "Curiosity"

                1 -> tab.text = "Opportunity"

                2 -> tab.text = "Spirit"
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_rover_cam,menu)
        return true
    }
}