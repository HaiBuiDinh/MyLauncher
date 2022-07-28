package com.ohno.mylauncher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home_screen.*

class HomeFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_screen, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        icon_drawer.setOnClickListener {
            loadFragment(AppsDrawerFragment())
        }
    }

    fun loadFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}