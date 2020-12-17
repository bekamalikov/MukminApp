package com.kg.malikov.mukminapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView


class NavigationDrawerFragment : BottomSheetDialogFragment() {
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

        navigationView.setNavigationItemSelectedListener {
            NavigationUI.onNavDestinationSelected(it, findNavController())
            it.isChecked = true
            dismiss()
            return@setNavigationItemSelectedListener true
        }

        /*  val onNavigationItemSelectedListener =
              BottomNavigationView.OnNavigationItemSelectedListener { item ->

                  when (item.itemId) {
                      R.id.name_item_menu -> {
                          findNavController().navigate(R.id.nav_name)
                          findNavController().navigateUp()
                          dismiss()


                      }
                      R.id.dua_item_menu -> {
                          findNavController().navigate(R.id.nav_dua)
                          findNavController().navigateUp()
                          dismiss()

                      }
                      R.id.hadis_item_menu -> {
                          findNavController().navigate(R.id.nav_hadis)
                          findNavController().navigateUp()
                          dismiss()

                      }
                      R.id.namaz_item_menu -> {
                          findNavController().navigate(R.id.nav_namaz)
                          dismiss()
                      }
                      R.id.qt_item_menu -> {
                          findNavController().navigate(R.id.nav_quran)

                          dismiss()
                      }
                      R.id.share_item_menu -> {
                          showToast("6")
                      }
                      R.id.other_item_menu -> {
                          showToast("7")
                      }

                  }


                  return@OnNavigationItemSelectedListener true
              }

          }*/


    }


}