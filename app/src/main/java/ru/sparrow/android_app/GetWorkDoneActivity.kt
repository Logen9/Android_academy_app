package ru.sparrow.android_app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "GetWorkDoneActivity"
const val END_RESULT_DATA = "end_result"

class GetWorkDoneActivity : AppCompatActivity() {

    val br: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            sendDataToMain(intent.getStringExtra(NEEDED_DATA)!!)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_work_done)
        val filter = IntentFilter()
        filter.addAction(BROADCAST_ACTION)
        filter.addCategory(Intent.CATEGORY_DEFAULT)
        registerReceiver(br, filter)

        val serviceIntent = Intent().apply {
            putExtra(EXTRA_MESSAGE, "mac?")
        }

        val myService = DoSomethingService()
        myService.enqueueWork(this, serviceIntent)



    }

    fun sendDataToMain(value: String) {
        val intent = Intent(applicationContext, MainActivity::class.java);
        intent.putExtra(END_RESULT_DATA, value)
        startActivity(intent);
    }
}