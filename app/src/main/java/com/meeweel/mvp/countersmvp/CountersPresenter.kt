package com.meeweel.mvp.countersmvp

import com.meeweel.mvp.R

class CountersPresenter(private val view: CountersView) {

    private val model = CountersModel()

    fun counterClick(id: Int) {
        when (id) {
            R.id.main_activity_counter_1_button -> {
                val nextValue = model.next(0)
                view.setButton(0, nextValue.toString())
            }
            R.id.main_activity_counter_2_button -> {
                val nextValue = model.next(1)
                view.setButton(1, nextValue.toString())
            }
            R.id.main_activity_counter_3_button -> {
                val nextValue = model.next(2)
                view.setButton(2, nextValue.toString())
            }
        }
    }
}