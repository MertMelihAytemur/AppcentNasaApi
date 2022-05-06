package com.example.appcentnasaapi.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.appcentnasaapi.ui.home.rovers.curiosity.CuriosityFragment
import com.example.appcentnasaapi.ui.home.rovers.opportunity.OpportunityFragment
import com.example.appcentnasaapi.ui.home.rovers.spirit.SpiritFragment


/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
class ViewPagerAdapter(fragmentManager : FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
       return  when(position){
            0 -> {CuriosityFragment()}
            1 -> {OpportunityFragment()}
            2 -> {SpiritFragment()}

            else -> {Fragment()}
        }
    }
}