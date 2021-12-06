package com.meeweel.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meeweel.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        with (bind) {
            mainActivityButton.setOnClickListener {
                (if (mainActivityTextView.text.equals("First text")) "Second text" else "First text")
                    .also { mainActivityTextView.text = it }
            }
        }
    }
}