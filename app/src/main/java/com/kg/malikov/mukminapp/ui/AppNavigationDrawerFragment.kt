package com.kg.malikov.mukminapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import com.kg.malikov.mukminapp.MainActivity
import com.kg.malikov.mukminapp.R


class AppNavigationDrawerFragment : BottomSheetDialogFragment() {
    lateinit var navigationView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationView = view.findViewById(R.id.navigation_view)
        navigationView.setupWithNavController(findNavController())
        navSelected()
    }

    private fun navSelected() {
        navigationView.setNavigationItemSelectedListener {
            NavigationUI.onNavDestinationSelected(it, findNavController())
            it.isChecked = true
            dismiss()
            return@setNavigationItemSelectedListener true
        }
    }
}