package com.task.sunsporttask.mainScreen.presentation

sealed class MainStatus(var data: Any? = null) {
    object ShowLoading : MainStatus()
    object ShowNoResults : MainStatus()
    object DataError : MainStatus()
    object ShowUserListView : MainStatus()
}