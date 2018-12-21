package com.example.jonathansimonney.igeneration

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.example.g123k.myapplication.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    data class Tab(val title :String, val fragment: Fragment, val menuId: Int)

    var tabList :MutableList<Tab> = ArrayList()

    private val stringIndexTabCorrespondance = HashMap<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTabsData()

        setViewPager()

        val initialFragmentIndex = stringIndexTabCorrespondance["news"] ?: 0

        setFragment(initialFragmentIndex)
        setToolbarTitle(tabList[initialFragmentIndex].title)
        setMenuListener()
    }

    //used by other fragments
    fun changeTab(newTabIndex :String){
        setFragment(stringIndexTabCorrespondance[newTabIndex] ?: 0)
    }

    private fun setTabsData(){
        tabList.add(Tab(resources.getString(R.string.news), NewsFragment.newInstance(), R.id.action_news))
        stringIndexTabCorrespondance["news"] = 0
        tabList.add(Tab(resources.getString(R.string.forum), ForumFragment.newInstance(), R.id.action_forum))
        stringIndexTabCorrespondance["forum"] = 1
        tabList.add(Tab(resources.getString(R.string.books), BooksFragment.newInstance(), R.id.action_books))
        stringIndexTabCorrespondance["books"] = 2
        tabList.add(Tab(resources.getString(R.string.club_igen), ClubIgenFragment.newInstance(), R.id.action_club_igen))
        stringIndexTabCorrespondance["club_igen"] = 3
        tabList.add(Tab(resources.getString(R.string.settings), SettingsFragment.newInstance(), R.id.action_settings))
        stringIndexTabCorrespondance["settings"] = 4
    }

    private fun setViewPager(){
        myFragmentContainer.adapter = MainPagerAdapter(supportFragmentManager, tabList.map { tab -> tab.fragment })
        myFragmentContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                val newTab = tabList[position]
                setToolbarTitle(newTab.title)
                bottom_navigation.selectedItemId = newTab.menuId
            }

        })
    }

    private fun setFragment(fragmentIndex :Int) {
        myFragmentContainer.currentItem = fragmentIndex
    }

    private fun setToolbarTitle(newTitle :String) {
        z_toolbar.title = newTitle
        setSupportActionBar(z_toolbar)
    }

    private fun setMenuListener(){
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.action_news -> setFragment(stringIndexTabCorrespondance["news"] ?: 0)
                R.id.action_forum -> setFragment(stringIndexTabCorrespondance["forum"] ?: 0)
                R.id.action_books -> setFragment(stringIndexTabCorrespondance["books"] ?: 0)
                R.id.action_club_igen -> setFragment(stringIndexTabCorrespondance["club_igen"] ?: 0)
                R.id.action_settings -> setFragment(stringIndexTabCorrespondance["settings"] ?: 0)
            }
            true
        }
    }
}
