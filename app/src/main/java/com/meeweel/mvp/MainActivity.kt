package com.meeweel.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meeweel.mvp.databinding.ActivityMainBinding
import com.meeweel.mvp.mvp.GreetingView
import com.meeweel.mvp.mvp.MyPresenter

class MainActivity : AppCompatActivity(), GreetingView {

    private lateinit var bind: ActivityMainBinding
    private val presenter: MyPresenter = MyPresenter()
    private val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        presenter.onAttach(this)
        with (bind) {
            mainActivityButton.setOnClickListener {
                (if (mainActivityTextView.text.equals("First text")) "Second text" else "First text")
                    .also { mainActivityTextView.text = it }
            }
        }
        bind.mainActivityPresenterButton.setOnClickListener {
            presenter.onButtonClick()
        }
        bind.mainActivityCounter1Button.setOnClickListener {
            val newValue = ((++counters[0]).toString())
            bind.mainActivityCounter1Button.text = newValue
        }
        bind.mainActivityCounter2Button.setOnClickListener {
            val newValue = ((++counters[1]).toString())
            bind.mainActivityCounter2Button.text = newValue
        }
        bind.mainActivityCounter3Button.setOnClickListener {
            val newValue = ((++counters[2]).toString())
            bind.mainActivityCounter3Button.text = newValue
        }
    }

    override fun setGreeting(greeting: String) {
        bind.mainActivityPresenterButton.text = greeting
    }
}