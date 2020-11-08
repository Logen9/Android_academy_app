package ru.sparrow.android_app

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.Toast
import androidx.core.app.JobIntentService

private const val TAG = "DoSomethingService"
private const val MYSERVICE_JOB_ID = 1000
const val BROADCAST_ACTION = "ru.sparrow.android_app.BROADCAST"
const val NEEDED_DATA = "ru.sparrow.android_app.STATUS"

class DoSomethingService: JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        val neededWork: String ?= intent.getStringExtra(EXTRA_MESSAGE)

        if (neededWork == "mac?") {
            val wifiManager: WifiManager =
                applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val wifiInfo: WifiInfo = wifiManager.connectionInfo
            val mac: String = wifiInfo.macAddress

            Intent().also { intent ->
                intent.putExtra(NEEDED_DATA, mac)
                intent.setAction(BROADCAST_ACTION)
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                sendBroadcast(intent)
            }

        } else {
            Log.w(TAG, "Intent didn't contain what was expected!")
        }
    }

    fun enqueueWork(context: Context, intent: Intent) {
        enqueueWork(context, DoSomethingService::class.java, MYSERVICE_JOB_ID, intent)
    }
}