package com.kg.malikov.mukminapp.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.kg.malikov.mukminapp.R

class TimeNotification : BroadcastReceiver() {

    override fun onReceive(context: Context, p1: Intent?) {
        val builder = NotificationCompat.Builder(context, "notify")
            .setSmallIcon(R.drawable.ic_icon_qibla)
            .setContentTitle("Namaz time")
            .setContentText("Намаз окунуз")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(200, builder.build())
    }
}