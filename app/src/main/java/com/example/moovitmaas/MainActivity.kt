package com.example.moovitmaas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.moovitmaas.fragments.HomeFragment
import com.example.moovitmaas.fragments.MapsFragment
import com.example.moovitmaas.fragments.PersonFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val personFragment = PersonFragment()
        val mapsFragment = MapsFragment()

        makeCurrentFragment(homeFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_baseline_home_24 -> makeCurrentFragment(homeFragment)
                R.id.ic_baseline_person_24 -> makeCurrentFragment(personFragment)
                R.id.ic_baseline_map_24 -> makeCurrentFragment(mapsFragment)
            }
            true
        }

    }

    override fun onStart() {
        super.onStart()
        buildList()
    }


    private fun buildList() {
        val visitedPlaces = ArrayList<String>()
        visitedPlaces.add("661 Jacobson Spring")
        visitedPlaces.add("230 Cummings Cliffs")
        visitedPlaces.add("7283 Schowalter Circle")
        visitedPlaces.add("5393 Runte Freeway")
        visitedPlaces.add("965 Joanne Harbor")
        val lv = findViewById<ListView>(R.id.noteList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, visitedPlaces)
        lv.adapter = adapter
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
}