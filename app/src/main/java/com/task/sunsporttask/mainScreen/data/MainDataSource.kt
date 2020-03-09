package com.task.sunsporttask.mainScreen.data

class MainDataSource(private val userService: UserService) : IMainDataSource {
    override suspend fun getUsers(page: Int, numberOfItemPerPage: Int):MainUserResponse {
       return userService.getUsers(page, numberOfItemPerPage)
    }
}