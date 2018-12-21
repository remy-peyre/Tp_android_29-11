package com.example.jonathansimonney.igeneration

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MainPagerAdapter(fm :FragmentManager) : FragmentPagerAdapter(fm) {
    private lateinit var fragmentList :List<Fragment>

    constructor(fm :FragmentManager, fragmentList: List<Fragment>) : this(fm) {
        this.fragmentList = fragmentList
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    fun setFragment(){

    }
}