package com.example.jonathansimonney.igeneration

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.preference.PreferenceFragmentCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.R.xml
import android.support.customtabs.CustomTabsIntent
import android.support.v7.preference.Preference


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val stringResource = "param1"
private const val ARG_PARAM2 = "param2"


class SettingsPreferenceFragment : PreferenceFragmentCompat() {
    // TODO: Rename and change types of parameters
//    private var stringResource: String? = null

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//
//        return inflater.inflate(R.layout.fragment_settings, container, false)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        addPreferencesFromResource(R.xml.preferences)
//    }


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // Load the preferences from an XML resource
        setPreferencesFromResource(R.xml.preferences, rootKey)
        setPreferencesListener()
    }

    private fun setPreferencesListener(){
        setLegalPrefListener()
        setWebsitePrefListener()
    }

    private fun setWebsitePrefListener(){
        val websitePref = findPreference("website") as Preference
        websitePref.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            val corrActivity = activity as MainActivity
            corrActivity.changeTab("club_igen")
            true
        }
    }

    private fun setLegalPrefListener(){
        val legalPref = findPreference("legal") as Preference
        legalPref.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            this.openCustomTab("https://www.google.fr")
            true
        }
    }

    private fun openCustomTab(url :String){
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(activity, Uri.parse(url))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
                SettingsPreferenceFragment().apply {
                    arguments = Bundle().apply {
//                        putString(stringResource, param1)
                    }
                }
    }
}
