package com.task.sunsporttask.mainScreen.prenstation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.sunsporttask.mainScreen.data.IMainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: IMainRepository) : ViewModel() {

    val searchResultLiveData by lazy { searchResultMutableLiveData }
    private val searchResultMutableLiveData by lazy { MutableLiveData<MainStatus>() }
    private var page = 0
    val numberPerPage = 10
    private var loading = false

    fun getUser() {

        viewModelScope.launch {
            searchResultMutableLiveData.value = MainStatus.ShowLoading
            runCatching {
                repository.getUsers(page, numberPerPage)

            }.onSuccess {
                searchResultMutableLiveData.value = MainStatus.ShowUserListView.apply {
                    data = it.users
                }
            }.onFailure {
                searchResultMutableLiveData.value = MainStatus.DataError.apply {
                    data = it.message
                }

            }
        }


    }
}