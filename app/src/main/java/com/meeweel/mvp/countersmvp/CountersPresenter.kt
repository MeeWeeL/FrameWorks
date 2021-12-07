package com.meeweel.mvp.countersmvp

class CountersPresenter(private val view: CountersView) {

    private val mapper = EnumMapper()
    private val model = CountersModel(mapper)

    fun counterClick(type: ButtonTypeEnum) {
        val nextValue = model.next(type)
        val uiModel = ButtonUiModel(type, nextValue.toString())
        view.setButtonText(uiModel)
    }
}