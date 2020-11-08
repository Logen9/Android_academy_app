package ru.sparrow.android_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView

const val EXTRA_MESSAGE = "ru.sparrow.android_app.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message: String? = intent.getStringExtra(END_RESULT_DATA)
        if (message != null) {
            val textView = findViewById<TextView>(R.id.textView).apply {
                text = message
            }
        }
    }

    fun sendMessage(view: View) {
        val message: String = "mac?"
        val intent: Intent = Intent(this, GetWorkDoneActivity::class.java).apply { putExtra(
            EXTRA_MESSAGE, message)  }

        startActivity(intent)
    }
}