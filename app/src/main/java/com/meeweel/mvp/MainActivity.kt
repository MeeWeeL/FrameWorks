package com.meeweel.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.meeweel.mvp.countersmvp.CountersPresenter
import com.meeweel.mvp.countersmvp.CountersView
import com.meeweel.mvp.databinding.ActivityMainBinding
import com.meeweel.mvp.mvp.GreetingView
import com.meeweel.mvp.mvp.MyPresenter

class MainActivity : AppCompatActivity(), GreetingView, CountersView {

    private lateinit var bind: ActivityMainBinding
    private val presenter: MyPresenter = MyPresenter()
    private val countersPresenter = CountersPresenter(this)
    private lateinit var listener: View.OnClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        presenter.onAttach(this)

        setListener()

        with(bind) {
            mainActivityButton.setOnClickListener {
                (if (mainActivityTextView.text.equals("First text")) "Second text" else "First text")
                    .also { mainActivityTextView.text = it }
            }
            mainActivityPresenterButton.setOnClickListener {
                presenter.onButtonClick()
            }
            mainActivityCounter1Button.setOnClickListener(listener)
            mainActivityCounter2Button.setOnClickListener(listener)
            mainActivityCounter3Button.setOnClickListener(listener)
        }
    }

    override fun setGreeting(greeting: String) {
        bind.mainActivityPresenterButton.text = greeting
    }

    override fun setButton(index: Int, text: String) {
        when (index) {
            0 -> bind.mainActivityCounter1Button.text = text
            1 -> bind.mainActivityCounter2Button.text = text
            2 -> bind.mainActivityCounter3Button.text = text
        }
    }

    private fun setListener() {
        listener = View.OnClickListener {
            val id = when (it.id) {
                R.id.main_activity_counter_1_button -> 0
                R.id.main_activity_counter_2_button -> 1
                else -> 2
            }
            countersPresenter.counterClick(id)
        }
    }
}