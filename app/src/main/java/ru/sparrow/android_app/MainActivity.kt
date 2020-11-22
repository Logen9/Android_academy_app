package ru.sparrow.android_app

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.Movie_button)
        textView.setOnClickListener {moveToScreen()}
        }

    private fun moveToScreen(){
        val intent = Intent(this, MovieDetailsActivity::class.java)

        startActivity(intent)
    }

}