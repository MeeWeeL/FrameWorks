package com.meeweel.mvp.countersmvp

import moxy.MvpPresenter

class CountersPresenter : MvpPresenter<CountersView>() {

    private val mapper = EnumMapper()
    private val model = CountersModel(mapper)

    override fun attachView(view: CountersView?) {
        super.attachView(view)
        val countersCount = ButtonTypeEnum.values().size - 1
        for (index in 0..countersCount) {
            val enumValue = mapper.mapIndexToEnum(index)
            val uiModel = ButtonUiModel(enumValue, model.getCurrent(enumValue).toString())
            viewState.setButtonText(uiModel)
        }
    }

    fun counterClick(type: ButtonTypeEnum) {
        val nextValue = model.next(type)
        val uiModel = ButtonUiModel(type, nextValue.toString())
        viewState.setButtonText(uiModel)
    }
}