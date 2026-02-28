package com.antutu.ABenchMark
import android.app.*
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class DummyService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val channelId = "dummy"
        val chan = NotificationChannel(channelId, "Running", NotificationManager.IMPORTANCE_NONE)
        getSystemService(NotificationManager::class.java).createNotificationChannel(chan)
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Benchmark Active")
            .setSmallIcon(android.R.drawable.ic_menu_info_details)
            .build()
        startForeground(1, notification)
        return START_STICKY
    }
    override fun onBind(p0: Intent?): IBinder? = null
}
