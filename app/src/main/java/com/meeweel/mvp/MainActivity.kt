package com.meeweel.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.meeweel.mvp.countersmvp.ButtonTypeEnum
import com.meeweel.mvp.countersmvp.ButtonUiModel
import com.meeweel.mvp.countersmvp.CountersPresenter
import com.meeweel.mvp.countersmvp.CountersView
import com.meeweel.mvp.databinding.ActivityMainBinding
import com.meeweel.mvp.mvp.GreetingView
import com.meeweel.mvp.mvp.MyPresenter
import java.lang.NullPointerException

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

    override fun setButtonText(model: ButtonUiModel) {
        val newValue = model.value
        when (model.index) {
            ButtonTypeEnum.FIRST_BUTTON -> bind.mainActivityCounter1Button.text = newValue
            ButtonTypeEnum.SECOND_BUTTON -> bind.mainActivityCounter2Button.text = newValue
            ButtonTypeEnum.THIRD_BUTTON -> bind.mainActivityCounter3Button.text = newValue
        }
    }

    private fun setListener() {
        listener = View.OnClickListener {
            val type = when (it.id) {
                R.id.main_activity_counter_1_button -> ButtonTypeEnum.FIRST_BUTTON
                R.id.main_activity_counter_2_button -> ButtonTypeEnum.SECOND_BUTTON
                R.id.main_activity_counter_3_button -> ButtonTypeEnum.THIRD_BUTTON
                else -> throw NullPointerException("Error")
            }
            countersPresenter.counterClick(type)
        }
    }
}