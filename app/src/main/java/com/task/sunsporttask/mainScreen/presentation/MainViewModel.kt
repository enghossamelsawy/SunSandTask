package com.task.sunsporttask.mainScreen.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.sunsporttask.base.exception.APIException
import com.task.sunsporttask.mainScreen.data.IMainRepository
import com.task.sunsporttask.mainScreen.data.User
import kotlinx.coroutines.launch

class MainViewModel(private val repository: IMainRepository) : ViewModel() {

    val searchResultLiveData by lazy { searchResultMutableLiveData }
    private val searchResultMutableLiveData by lazy { MutableLiveData<MainStatus>() }

    val searchResultLoadingLiveData by lazy { searchResultLoadingMutableLiveData }
    private val searchResultLoadingMutableLiveData by lazy { MutableLiveData<ViewLoadingState>() }
    private var page = 0
    private val numberPerPage = 10

    fun getUser() {
        viewModelScope.launch {
            if (page == 0) {
                searchResultLoadingMutableLiveData.value = ViewLoadingState.ShowLoading
            } else {
                searchResultLoadingMutableLiveData.value = ViewLoadingState.ShowLoadMoreLoading
            }
            runCatching {
                repository.getUsers(page, numberPerPage)

            }.onSuccess {
                onUserGotSuccess(it.users)
            }.onFailure {
                onUserGotFailure(it)
            }
        }

    }


    private fun onUserGotSuccess(it: List<User>) {
        if (page == 0) {
            searchResultLoadingMutableLiveData.value = ViewLoadingState.HideLoading
        } else {
            searchResultLoadingMutableLiveData.value = ViewLoadingState.HideLoadMoreLoading
        }
        if (it.isEmpty() && page == 0) {
            searchResultMutableLiveData.value =
                MainStatus.ShowNoResults
        } else {
            searchResultMutableLiveData.value =
                MainStatus.ShowUserListView.apply { data = it }
            if (page == 0) {
                searchResultMutableLiveData.value = MainStatus.ShowUserListView
            }
        }
        page++
    }

    private fun onUserGotFailure(throwable: Throwable) {
        if (page == 0) {
            searchResultLoadingMutableLiveData.value = ViewLoadingState.HideLoading
        } else {
            searchResultLoadingMutableLiveData.value = ViewLoadingState.HideLoadMoreLoading
        }
        if (throwable is APIException) {
            val isFirstPage = page == 0
            searchResultMutableLiveData.value =
                MainStatus.ConnectionError.apply { data = isFirstPage }
        } else {
            searchResultMutableLiveData.value = MainStatus.DataError.apply {
                data = throwable.message
            }

        }

    }

}