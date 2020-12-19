package com.kg.malikov.mukminapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kg.malikov.mukminapp.databinding.ActivityMainBinding
import com.kg.malikov.mukminapp.ui.AppNavigationDrawerFragment
import com.kg.malikov.mukminapp.ui.fragments.compass.CompassFragment
import com.kg.malikov.mukminapp.ui.fragments.main.MainFragment
import com.kg.malikov.mukminapp.utils.replaceFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var appBar: BottomAppBar
    private lateinit var bottomNavDrawerFragment: AppNavigationDrawerFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var fab: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        init()
        showBottomSheet()
        listener()
    }


    private fun init() {
        appBar = mBinding.bottomAppBar
        drawerLayout = mBinding.drawerLayout
        bottomNavDrawerFragment = AppNavigationDrawerFragment()
        fab = mBinding.fabAppBarQibla
        bottomNavDrawerFragment.fab = fab
    }

    private fun listener() {
        var b = false
        fab.setOnClickListener {
            if (!b) {
                b = true
                fab.setImageResource(R.drawable.ic_share)
                replaceFragment(CompassFragment(), false)
            } else {
                b = false
                fab.setImageResource(R.drawable.ic_icon_qibla)
                replaceFragment(MainFragment(), false)
            }
        }
    }

    private fun showBottomSheet() {
        appBar.setNavigationOnClickListener {
            bottomNavDrawerFragment.setStyle(
                DialogFragment.STYLE_NO_FRAME,
                R.style.AppBottomSheetDialogTheme
            )
            bottomNavDrawerFragment.show(supportFragmentManager, "TAG")
        }
    }


}