package com.meeweel.mvp.countersmvp

class CountersPresenter(private val view: CountersView) {

    private val model = CountersModel()

    fun counterClick(id: Int) {
        val nextValue = model.next(id)
        view.setButton(id, nextValue.toString())
    }
}