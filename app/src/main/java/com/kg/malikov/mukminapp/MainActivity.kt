package com.kg.malikov.mukminapp

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kg.malikov.mukminapp.databinding.ActivityMainBinding
import com.kg.malikov.mukminapp.interfaces.IOnFragmentInteractionListener
import com.kg.malikov.mukminapp.ui.AppNavigationDrawerFragment
import com.kg.malikov.mukminapp.ui.TimeNotification
import com.kg.malikov.mukminapp.ui.fragments.compass.CompassFragment
import com.kg.malikov.mukminapp.ui.fragments.main.MainFragment
import com.kg.malikov.mukminapp.ui.objects.AppHideFab
import com.kg.malikov.mukminapp.utils.initFirebase
import com.kg.malikov.mukminapp.utils.replaceFragment
import java.util.*

class MainActivity : AppCompatActivity(),
    IOnFragmentInteractionListener {
    private lateinit var mBinding: ActivityMainBinding
    lateinit var appBar: BottomAppBar
    private lateinit var bottomNavDrawerFragment: AppNavigationDrawerFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var alManager: AlarmManager
    private lateinit var fabHide: AppHideFab
    var fab: FloatingActionButton? = null
    private var b = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initFirebase()
        createNotification()
        init()
        showBottomSheet()
        listener()
    }

    private fun restartNotify() {
        alManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, TimeNotification::class.java)
        val pIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        val calendar: Calendar = Calendar.getInstance()
        val time = System.currentTimeMillis()
        val tenSeconds = 10 * 10
        Log.e("ololo", "restartNotify: $calendar")
        alManager.set(AlarmManager.RTC_WAKEUP, time + tenSeconds, pIntent);
    }

    private fun createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "LemubitReminderChannel"
            val desc = "Channel"
            val imp = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("notify", name, imp)
            channel.description = desc
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }


    private fun init() {
        appBar = mBinding.bottomAppBar
        drawerLayout = mBinding.drawerLayout
        bottomNavDrawerFragment = AppNavigationDrawerFragment()
        fab = mBinding.fabAppBarQibla
        fabHide = AppHideFab()
    }

    private fun listener() {
        fab?.setOnClickListener {
            //click and show compass
            if (!b) {
                b = true
                fab?.setImageResource(R.drawable.ic_share)
                replaceFragment(CompassFragment(), false)
                restartNotify()
            } else {
                //click and return main fragment
                b = false
                fab?.setImageResource(R.drawable.ic_icon_qibla)
                replaceFragment(MainFragment(), false)
            }
        }
        //hide fab in other fragment
        fabHide.hideFab(this, R.id.nav_host_fragment)
    }

    //fun show BottomSheetMenu
    private fun showBottomSheet() {
        appBar.setNavigationOnClickListener {
            bottomNavDrawerFragment.setStyle(
                DialogFragment.STYLE_NO_FRAME,
                R.style.AppBottomSheetDialogTheme
            )
            bottomNavDrawerFragment.show(supportFragmentManager, "TAG")
        }
    }

    //fun for hide/show bottom appBar
    override fun onFragmentScrolled(delta: Float) {
        appBar.translationY = appBar.translationY + delta
        if (appBar.translationY > appBar.height)
            appBar.translationY = appBar.height.toFloat()
        if (appBar.translationY < 0)
            appBar.translationY = 0f
    }


}