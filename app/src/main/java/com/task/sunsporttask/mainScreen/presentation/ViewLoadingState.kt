package com.task.sunsporttask.mainScreen.presentation

sealed class ViewLoadingState(var data: Any? = null) {
    object ShowLoading : ViewLoadingState()
    object HideLoading : ViewLoadingState()
    object ShowLoadMoreLoading : ViewLoadingState()
    object HideLoadMoreLoading : ViewLoadingState()

}