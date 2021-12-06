package com.meeweel.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meeweel.mvp.databinding.ActivityMainBinding
import com.meeweel.mvp.mvp.GreetingView
import com.meeweel.mvp.mvp.MyPresenter

class MainActivity : AppCompatActivity(), GreetingView {

    private lateinit var bind: ActivityMainBinding
    private val presenter: MyPresenter = MyPresenter()

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
    }

    override fun setGreeting(greeting: String) {
        bind.mainActivityPresenterButton.text = greeting
    }
}