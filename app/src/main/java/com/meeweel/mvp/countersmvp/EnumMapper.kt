package com.meeweel.mvp.countersmvp

class EnumMapper {

    fun mapEnumToIndex(enum: ButtonTypeEnum): Int {
        return when(enum){
            ButtonTypeEnum.FIRST_BUTTON -> 0
            ButtonTypeEnum.SECOND_BUTTON -> 1
            ButtonTypeEnum.THIRD_BUTTON -> 2
        }
    }

    fun mapIndexToEnum(index: Int): ButtonTypeEnum {
        return when(index){
            0 -> ButtonTypeEnum.FIRST_BUTTON
            1 -> ButtonTypeEnum.SECOND_BUTTON
            2 -> ButtonTypeEnum.THIRD_BUTTON
            else -> throw NullPointerException("not allowed this id")
        }
    }
}