package com.meeweel.mvp.mvp

class MyPresenter {
    private var greetingView: GreetingView? = null
    private val model = Model()

    fun onAttach(view: GreetingView) {
        greetingView = view
    }

    fun onButtonClick() {
        greetingView.let {
            val newTextOnButton = model.greeting // "Text of the button from the presenter"
            greetingView?.setGreeting(newTextOnButton)
        }
    }
}