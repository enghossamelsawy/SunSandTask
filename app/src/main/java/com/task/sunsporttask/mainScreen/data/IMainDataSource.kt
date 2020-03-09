package com.task.sunsporttask.mainScreen.data

interface IMainDataSource {
    suspend fun getUsers(page:Int,numberOfItemPerPage:Int):MainUserResponse
}