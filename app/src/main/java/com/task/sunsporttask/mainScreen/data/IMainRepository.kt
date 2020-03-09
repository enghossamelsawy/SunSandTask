package com.task.sunsporttask.mainScreen.data

interface IMainRepository {
    suspend fun getUsers(page: Int, numberOfItemPerPage: Int):MainUserResponse
}