package com.meeweel.mvp.countersmvp

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CountersView : MvpView {
    @StateStrategyType(AddToEndStrategy::class)
    fun setButtonText(model: ButtonUiModel)
}