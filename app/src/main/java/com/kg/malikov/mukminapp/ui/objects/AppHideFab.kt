package com.kg.malikov.mukminapp.ui.objects

import androidx.navigation.findNavController
import com.kg.malikov.mukminapp.MainActivity
import com.kg.malikov.mukminapp.R

class AppHideFab {
    var b = false
    fun hideFab(mainActivity: MainActivity, id: Int) {
        mainActivity.findNavController(id)
            .addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.id) {
                    R.id.nav_dua -> {
                        mainActivity.fab?.hide()

                    }
                    R.id.nav_name -> {
                        mainActivity.fab?.hide()
                    }
                    R.id.nav_hadis -> {
                        mainActivity.fab?.hide()
                    }
                    R.id.nav_namaz -> {
                        mainActivity.fab?.hide()
                    }
                    R.id.nav_quran -> {
                        mainActivity.fab?.hide()
                    }
                    R.id.nav_main -> {
                        mainActivity.fab?.setImageResource(R.drawable.ic_icon_qibla)
                        mainActivity.fab?.show()
                    }
                }
            }

    }
}